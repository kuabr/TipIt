package de.tipit.server.transfer.access.analysis;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import de.tipit.server.transfer.access.Analysis;
import de.tipit.server.transfer.access.AnalysisTask;
import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.data.BetCommunityNameTO;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;

public class GetParticipatingBetCommunities implements AnalysisTask {

    public static class Result implements ResultData {

        @ElementList(required = true, name = "betCommunityNameList")
        private final List<BetCommunityNameTO> betCommunityNameList;

        @Override
        public Object getValue() {
            return betCommunityNameList;
        }

        public Result(@ElementList(name = "betCommunityNameList") List<BetCommunityNameTO> betCommunityNameList) {
            this.betCommunityNameList = betCommunityNameList;
        }

        public List<BetCommunityNameTO> getBetCommunityNameList() {
            return betCommunityNameList;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Override
    public InvocationResult execute(Analysis delegate) {
        try {
            return new InvocationResult(new Result(delegate.getParticipatingBetCommunities(context, sessionId)));
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
}
