package de.tipit.server.transfer.access.tournament_admin;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.access.TournamentAdmin;
import de.tipit.server.transfer.access.TournamentAdminTask;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.TournamentIdTO;

public class IsTournamentModerator implements TournamentAdminTask {

    public static class Result implements ResultData {

        @Attribute(required = true, name = "isTournMod")
        private final Boolean isTournMod;

        @Override
        public Object getValue() {
            return isTournMod;
        }

        public Result(@Attribute(name = "isTournMod") Boolean isTournMod) {
            this.isTournMod = isTournMod;
        }

        public Boolean getIsTournMod() {
            return isTournMod;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private TournamentIdTO tournId;

    @Override
    public InvocationResult execute(TournamentAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.isTournamentModerator(context, sessionId, tournId)));
        } catch (GeneralError exc) {
            return new InvocationResult(exc);
        } catch (RuntimeException exc) {
            return new InvocationResult(exc);
        }
    }

    public ContextTO getContext() {
        return context;
    }

    public void setContext(ContextTO context) {
        this.context = context;
    }

    public SessionIdTO getSessionId() {
        return sessionId;
    }

    public void setSessionId(SessionIdTO sessionId) {
        this.sessionId = sessionId;
    }

    public TournamentIdTO getTournId() {
        return tournId;
    }

    public void setTournId(TournamentIdTO tournId) {
        this.tournId = tournId;
    }
}
