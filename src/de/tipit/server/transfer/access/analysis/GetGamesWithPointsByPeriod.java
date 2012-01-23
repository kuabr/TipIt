package de.tipit.server.transfer.access.analysis;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import de.tipit.server.transfer.access.Analysis;
import de.tipit.server.transfer.access.AnalysisTask;
import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.data.BetCommunityIdTO;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.GameWithPointsTO;
import de.tipit.server.transfer.data.PeriodTO;
import de.tipit.server.transfer.data.SessionIdTO;

public class GetGamesWithPointsByPeriod implements AnalysisTask {

    public static class Result implements ResultData {

        @ElementList(required = true, name = "gameWithPointsList")
        private final List<GameWithPointsTO> gameWithPointsList;

        @Override
        public Object getValue() {
            return gameWithPointsList;
        }

        public Result(@ElementList(name = "gameWithPointsList") List<GameWithPointsTO> gameWithPointsList) {
            this.gameWithPointsList = gameWithPointsList;
        }

        public List<GameWithPointsTO> getGameWithPointsList() {
            return gameWithPointsList;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private BetCommunityIdTO betCommunityId;

    @Element(required = true)
    private PeriodTO period;

    @Element(required = true)
    private Boolean onlyGamesWithResult;

    @Override
    public InvocationResult execute(Analysis delegate) {
        try {
            return new InvocationResult(new Result(delegate.getGamesWithPointsByPeriod(context, sessionId, betCommunityId, period, onlyGamesWithResult)));
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

    public BetCommunityIdTO getBetCommunityId() {
        return betCommunityId;
    }

    public void setBetCommunityId(BetCommunityIdTO betCommunityId) {
        this.betCommunityId = betCommunityId;
    }

    public PeriodTO getPeriod() {
        return period;
    }

    public void setPeriod(PeriodTO period) {
        this.period = period;
    }

    public Boolean getOnlyGamesWithResult() {
        return onlyGamesWithResult;
    }

    public void setOnlyGamesWithResult(Boolean onlyGamesWithResult) {
        this.onlyGamesWithResult = onlyGamesWithResult;
    }
}
