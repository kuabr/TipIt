package de.tipit.server.transfer.access.tournament_admin;

import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.access.TournamentAdmin;
import de.tipit.server.transfer.access.TournamentAdminTask;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.TournamentDataArgumentTO;
import de.tipit.server.transfer.data.TournamentIdTO;

public class CreateOrUpdateTournament implements TournamentAdminTask {

    public static class Result implements ResultData {

        @Element(required = true, name = "tournId")
        private final TournamentIdTO tournId;

        @Override
        public Object getValue() {
            return tournId;
        }

        public Result(@Element(name = "tournId") TournamentIdTO tournId) {
            this.tournId = tournId;
        }

        public TournamentIdTO getTournId() {
            return tournId;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private TournamentDataArgumentTO tournData;

    @Override
    public InvocationResult execute(TournamentAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.createOrUpdateTournament(context, sessionId, tournData)));
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

    public TournamentDataArgumentTO getTournData() {
        return tournData;
    }

    public void setTournData(TournamentDataArgumentTO tournData) {
        this.tournData = tournData;
    }
}
