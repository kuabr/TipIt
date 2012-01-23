package de.tipit.server.transfer.access.tournament_admin;

import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.access.TournamentAdmin;
import de.tipit.server.transfer.access.TournamentAdminTask;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.TournamentRoundDataArgumentTO;
import de.tipit.server.transfer.data.TournamentRoundIdTO;

public class CreateOrUpdateTournamentRound implements TournamentAdminTask {

    public static class Result implements ResultData {

        @Element(required = true, name = "tournRoundId")
        private final TournamentRoundIdTO tournRoundId;

        @Override
        public Object getValue() {
            return tournRoundId;
        }

        public Result(@Element(name = "tournRoundId") TournamentRoundIdTO tournRoundId) {
            this.tournRoundId = tournRoundId;
        }

        public TournamentRoundIdTO getTournRoundId() {
            return tournRoundId;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private TournamentRoundDataArgumentTO tournRoundData;

    @Override
    public InvocationResult execute(TournamentAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.createOrUpdateTournamentRound(context, sessionId, tournRoundData)));
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

    public TournamentRoundDataArgumentTO getTournRoundData() {
        return tournRoundData;
    }

    public void setTournRoundData(TournamentRoundDataArgumentTO tournRoundData) {
        this.tournRoundData = tournRoundData;
    }
}
