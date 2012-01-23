package de.tipit.server.transfer.access.bet_result;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import de.tipit.server.transfer.access.BetResult;
import de.tipit.server.transfer.access.BetResultTask;
import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.GameTO;
import de.tipit.server.transfer.data.PeriodTO;
import de.tipit.server.transfer.data.SessionIdTO;

public class GetGamesWithForgottenBetForPeriod implements BetResultTask {

    public static class Result implements ResultData {

        @ElementList(required = true, name = "gameList")
        private final List<GameTO> gameList;

        @Override
        public Object getValue() {
            return gameList;
        }

        public Result(@ElementList(name = "gameList") List<GameTO> gameList) {
            this.gameList = gameList;
        }

        public List<GameTO> getGameList() {
            return gameList;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private PeriodTO period;

    @Override
    public InvocationResult execute(BetResult delegate) {
        try {
            return new InvocationResult(new Result(delegate.getGamesWithForgottenBetForPeriod(context, sessionId, period)));
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

    public PeriodTO getPeriod() {
        return period;
    }

    public void setPeriod(PeriodTO period) {
        this.period = period;
    }
}
