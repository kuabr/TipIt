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
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.UserGroupPointsTO;

public class GetAllTimeRankingByUserGroup implements AnalysisTask {

    public static class Result implements ResultData {

        @ElementList(required = true, name = "userGroupPointsList")
        private final List<UserGroupPointsTO> userGroupPointsList;

        @Override
        public Object getValue() {
            return userGroupPointsList;
        }

        public Result(@ElementList(name = "userGroupPointsList") List<UserGroupPointsTO> userGroupPointsList) {
            this.userGroupPointsList = userGroupPointsList;
        }

        public List<UserGroupPointsTO> getUserGroupPointsList() {
            return userGroupPointsList;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private BetCommunityIdTO betCommunityId;

    @Override
    public InvocationResult execute(Analysis delegate) {
        try {
            return new InvocationResult(new Result(delegate.getAllTimeRankingByUserGroup(context, sessionId, betCommunityId)));
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
}
