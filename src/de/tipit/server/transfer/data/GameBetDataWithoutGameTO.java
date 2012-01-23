package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "GameBetDataWithoutGame")
public class GameBetDataWithoutGameTO extends GameBetIdTO {

    @Element(required = false)
    private Integer homeResult;

    @Element(required = false)
    private Integer awayResult;

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
}
