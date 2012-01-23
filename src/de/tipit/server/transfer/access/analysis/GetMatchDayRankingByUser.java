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
import de.tipit.server.transfer.data.MatchDayIdTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.UserPointsTO;

public class GetMatchDayRankingByUser implements AnalysisTask {

    public static class Result implements ResultData {

        @ElementList(required = true, name = "userPointsList")
        private final List<UserPointsTO> userPointsList;

        @Override
        public Object getValue() {
            return userPointsList;
        }

        public Result(@ElementList(name = "userPointsList") List<UserPointsTO> userPointsList) {
            this.userPointsList = userPointsList;
        }

        public List<UserPointsTO> getUserPointsList() {
            return userPointsList;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private BetCommunityIdTO betCommunityId;

    @Element(required = true)
    private MatchDayIdTO matchDayId;

    @Element(required = true)
    private Boolean onlyUsersWithBet;

    @Override
    public InvocationResult execute(Analysis delegate) {
        try {
            return new InvocationResult(new Result(delegate.getMatchDayRankingByUser(context, sessionId, betCommunityId, matchDayId, onlyUsersWithBet)));
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

    public MatchDayIdTO getMatchDayId() {
        return matchDayId;
    }

    public void setMatchDayId(MatchDayIdTO matchDayId) {
        this.matchDayId = matchDayId;
    }

    public Boolean getOnlyUsersWithBet() {
        return onlyUsersWithBet;
    }

    public void setOnlyUsersWithBet(Boolean onlyUsersWithBet) {
        this.onlyUsersWithBet = onlyUsersWithBet;
    }
}
