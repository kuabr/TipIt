package de.tipit.server.transfer.access.rules_admin;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.access.RulesAdmin;
import de.tipit.server.transfer.access.RulesAdminTask;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.RuleBookDataTO;
import de.tipit.server.transfer.data.SessionIdTO;

// 
public class CalculatePointsForNewRuleBook implements RulesAdminTask {

    public static class Result implements ResultData {

        @Attribute(required = true, name = "points")
        private final Integer points;

        @Override
        public Object getValue() {
            return points;
        }

        public Result(@Attribute(name = "points") Integer points) {
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private RuleBookDataTO ruleBookData;

    @Element(required = true)
    private Integer homeResult;

    @Element(required = true)
    private Integer awayResult;

    @Element(required = true)
    private Integer averageHomeResultBet;

    @Element(required = true)
    private Integer averageAwayResultBet;

    @Element(required = true)
    private Integer homeResultBet;

    @Element(required = true)
    private Integer awayResultBet;

    @Override
    public InvocationResult execute(RulesAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.calculatePointsForNewRuleBook(context, sessionId, ruleBookData, homeResult, awayResult,
                    averageHomeResultBet, averageAwayResultBet, homeResultBet, awayResultBet)));
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

    public Integer getHomeResult() {
        return homeResult;
    }

    public void setHomeResult(Integer homeResult) {
        this.homeResult = homeResult;
    }

    public Integer getAwayResult() {
        return awayResult;
    }

    public void setAwayResult(Integer awayResult) {
        this.awayResult = awayResult;
    }

    public Integer getAverageHomeResultBet() {
        return averageHomeResultBet;
    }

    public void setAverageHomeResultBet(Integer averageHomeResultBet) {
        this.averageHomeResultBet = averageHomeResultBet;
    }

    public Integer getAverageAwayResultBet() {
        return averageAwayResultBet;
    }

    public void setAverageAwayResultBet(Integer averageAwayResultBet) {
        this.averageAwayResultBet = averageAwayResultBet;
    }

    public Integer getHomeResultBet() {
        return homeResultBet;
    }

    public void setHomeResultBet(Integer homeResultBet) {
        this.homeResultBet = homeResultBet;
    }

    public Integer getAwayResultBet() {
        return awayResultBet;
    }

    public void setAwayResultBet(Integer awayResultBet) {
        this.awayResultBet = awayResultBet;
    }
}
