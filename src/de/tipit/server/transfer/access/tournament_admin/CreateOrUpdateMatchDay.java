package de.tipit.server.transfer.access.tournament_admin;

import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.access.TournamentAdmin;
import de.tipit.server.transfer.access.TournamentAdminTask;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.MatchDayDataArgumentTO;
import de.tipit.server.transfer.data.MatchDayIdTO;
import de.tipit.server.transfer.data.SessionIdTO;

public class CreateOrUpdateMatchDay implements TournamentAdminTask {

    public static class Result implements ResultData {

        @Element(required = true, name = "matchDayId")
        private final MatchDayIdTO matchDayId;

        @Override
        public Object getValue() {
            return matchDayId;
        }

        public Result(@Element(name = "matchDayId") MatchDayIdTO matchDayId) {
            this.matchDayId = matchDayId;
        }

        public MatchDayIdTO getMatchDayId() {
            return matchDayId;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private MatchDayDataArgumentTO matchDayData;

    @Override
    public InvocationResult execute(TournamentAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.createOrUpdateMatchDay(context, sessionId, matchDayData)));
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

    public MatchDayDataArgumentTO getMatchDayData() {
        return matchDayData;
    }

    public void setMatchDayData(MatchDayDataArgumentTO matchDayData) {
        this.matchDayData = matchDayData;
    }
}
