package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "GameResultData")
public class GameResultDataTO extends GameIdTO {

    public static enum CountingResultType {
        AFTER_REGULAR_TIME, AFTER_EXTRA_TIME
    }

    @Element(required = false)
    private Integer countingHomeResult;

    @Element(required = false)
    private Integer countingAwayResult;

    @Element(required = false)
    private CountingResultType countingResultType;

    @Element(required = false)
    private Integer homeResultInPenaltyShootOut;

    @Element(required = false)
    private Integer awayResultInPenaltyShootOut;

    public Integer getCountingHomeResult() {
        return countingHomeResult;
    }

    public void setCountingHomeResult(Integer countingHomeResult) {
        this.countingHomeResult = countingHomeResult;
    }

    public Integer getCountingAwayResult() {
        return countingAwayResult;
    }

    public void setCountingAwayResult(Integer countingAwayResult) {
        this.countingAwayResult = countingAwayResult;
    }

    public CountingResultType getCountingResultType() {
        return countingResultType;
    }

    public void setCountingResultType(CountingResultType countingResultType) {
        this.countingResultType = countingResultType;
    }

    public Integer getHomeResultInPenaltyShootOut() {
        return homeResultInPenaltyShootOut;
    }

    public void setHomeResultInPenaltyShootOut(Integer homeResultInPenaltyShootOut) {
        this.homeResultInPenaltyShootOut = homeResultInPenaltyShootOut;
    }

    public Integer getAwayResultInPenaltyShootOut() {
        return awayResultInPenaltyShootOut;
    }

    public void setAwayResultInPenaltyShootOut(Integer awayResultInPenaltyShootOut) {
        this.awayResultInPenaltyShootOut = awayResultInPenaltyShootOut;
    }
}
