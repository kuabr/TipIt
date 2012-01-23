package de.tipit.server.transfer.access.community_admin;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import de.tipit.server.transfer.access.CommunityAdmin;
import de.tipit.server.transfer.access.CommunityAdminTask;
import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.RuleBookNameTO;
import de.tipit.server.transfer.data.SessionIdTO;

public class GetAllFinalRuleBooks implements CommunityAdminTask {

    public static class Result implements ResultData {

        @ElementList(required = true, name = "ruleBookNameList")
        private final List<RuleBookNameTO> ruleBookNameList;

        @Override
        public Object getValue() {
            return ruleBookNameList;
        }

        public Result(@ElementList(name = "ruleBookNameList") List<RuleBookNameTO> ruleBookNameList) {
            this.ruleBookNameList = ruleBookNameList;
        }

        public List<RuleBookNameTO> getRuleBookNameList() {
            return ruleBookNameList;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Override
    public InvocationResult execute(CommunityAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.getAllFinalRuleBooks(context, sessionId)));
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
