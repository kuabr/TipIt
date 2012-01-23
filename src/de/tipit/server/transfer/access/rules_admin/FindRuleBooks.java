package de.tipit.server.transfer.access.rules_admin;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.access.RulesAdmin;
import de.tipit.server.transfer.access.RulesAdminTask;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.RuleBookNameTO;
import de.tipit.server.transfer.data.RuleBookSearchDataTO;
import de.tipit.server.transfer.data.SessionIdTO;

public class FindRuleBooks implements RulesAdminTask {

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

    @Element(required = true)
    private RuleBookSearchDataTO ruleBookSearchData;

    @Override
    public InvocationResult execute(RulesAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.findRuleBooks(context, sessionId, ruleBookSearchData)));
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

    public RuleBookSearchDataTO getRuleBookSearchData() {
        return ruleBookSearchData;
    }

    public void setRuleBookSearchData(RuleBookSearchDataTO ruleBookSearchData) {
        this.ruleBookSearchData = ruleBookSearchData;
    }
}
