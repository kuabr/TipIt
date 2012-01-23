package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "GameDataResult")
public class GameDataResultTO extends GameDataBaseTO {

    @Element(required = false)
    private MatchDayDescrTO matchDayDescr;

    @Element(required = false)
    private TeamNameTO homeTeamName;

    @Element(required = false)
    private TeamNameTO awayTeamName;

    public MatchDayDescrTO getMatchDayDescr() {
        return matchDayDescr;
    }

    public void setMatchDayDescr(MatchDayDescrTO matchDayDescr) {
        this.matchDayDescr = matchDayDescr;
    }

    public TeamNameTO getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(TeamNameTO homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public TeamNameTO getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(TeamNameTO awayTeamName) {
        this.awayTeamName = awayTeamName;
    }
}
