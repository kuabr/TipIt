package de.tipit.server.transfer.access.rules_admin;

import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.access.RulesAdmin;
import de.tipit.server.transfer.access.RulesAdminTask;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.RuleBookDataTO;
import de.tipit.server.transfer.data.RuleBookIdTO;
import de.tipit.server.transfer.data.SessionIdTO;

public class CreateOrUpdateRuleBook implements RulesAdminTask {

    public static class Result implements ResultData {

        @Element(required = true, name = "ruleBookId")
        private final RuleBookIdTO ruleBookId;

        @Override
        public Object getValue() {
            return ruleBookId;
        }

        public Result(@Element(name = "ruleBookId") RuleBookIdTO ruleBookId) {
            this.ruleBookId = ruleBookId;
        }

        public RuleBookIdTO getRuleBookId() {
            return ruleBookId;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private RuleBookDataTO ruleBookData;

    @Override
    public InvocationResult execute(RulesAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.createOrUpdateRuleBook(context, sessionId, ruleBookData)));
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

    public RuleBookDataTO getRuleBookData() {
        return ruleBookData;
    }

    public void setRuleBookData(RuleBookDataTO ruleBookData) {
        this.ruleBookData = ruleBookData;
    }
}
