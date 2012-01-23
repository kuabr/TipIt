package de.tipit.server.transfer.data;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "Game")
public class GameTO extends GameDataResultTO {

    @Element(required = false)
    private Integer averageHomeResultBet;

    @Element(required = false)
    private Integer averageAwayResultBet;

    @ElementList(required = false)
    private List<GameBetTO> bets;

    @Element(required = false)
    private GameResultTO result;

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

    public List<GameBetTO> getBets() {
        return bets;
    }

    public void setBets(List<GameBetTO> bets) {
        this.bets = bets;
    }

    public GameResultTO getResult() {
        return result;
    }

    public void setResult(GameResultTO result) {
        this.result = result;
    }
}
