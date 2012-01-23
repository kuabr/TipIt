package de.tipit.server.transfer.access.rules_admin;

import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.access.RulesAdmin;
import de.tipit.server.transfer.access.RulesAdminTask;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.RuleBookIdTO;
import de.tipit.server.transfer.data.RuleBookTO;
import de.tipit.server.transfer.data.SessionIdTO;

public class ReadRuleBook implements RulesAdminTask {

    public static class Result implements ResultData {

        @Element(required = true, name = "ruleBook")
        private final RuleBookTO ruleBook;

        @Override
        public Object getValue() {
            return ruleBook;
        }

        public Result(@Element(name = "ruleBook") RuleBookTO ruleBook) {
            this.ruleBook = ruleBook;
        }

        public RuleBookTO getRuleBook() {
            return ruleBook;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private RuleBookIdTO ruleBookId;

    @Override
    public InvocationResult execute(RulesAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.readRuleBook(context, sessionId, ruleBookId)));
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

    public RuleBookIdTO getRuleBookId() {
        return ruleBookId;
    }

    public void setRuleBookId(RuleBookIdTO ruleBookId) {
        this.ruleBookId = ruleBookId;
    }
}
