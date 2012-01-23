package de.tipit.server.transfer.data;

import java.util.Date;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "GameDataBase")
public class GameDataBaseTO extends GameIdTO {

    @Attribute(required = false)
    private Integer gameNumber;

    @Element(required = false)
    private Date matchPoint;

    @Element(required = false)
    private String homeTeamPlaceHolder;

    @Element(required = false)
    private String awayTeamPlaceHolder;

    public Integer getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(Integer gameNumber) {
        this.gameNumber = gameNumber;
    }

    public Date getMatchPoint() {
        return matchPoint;
    }

    public void setMatchPoint(Date matchPoint) {
        this.matchPoint = matchPoint;
    }

    public String getHomeTeamPlaceHolder() {
        return homeTeamPlaceHolder;
    }

    public void setHomeTeamPlaceHolder(String homeTeamPlaceHolder) {
        this.homeTeamPlaceHolder = homeTeamPlaceHolder;
    }

    public String getAwayTeamPlaceHolder() {
        return awayTeamPlaceHolder;
    }

    public void setAwayTeamPlaceHolder(String awayTeamPlaceHolder) {
        this.awayTeamPlaceHolder = awayTeamPlaceHolder;
    }
}
