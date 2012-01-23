package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "GameDataArgument")
public class GameDataArgumentTO extends GameDataBaseTO {

    @Element(required = false)
    private MatchDayIdTO matchDayId;

    @Element(required = false)
    private TeamIdTO homeTeamId;

    @Element(required = false)
    private TeamIdTO awayTeamId;

    public MatchDayIdTO getMatchDayId() {
        return matchDayId;
    }

    public void setMatchDayId(MatchDayIdTO matchDayId) {
        this.matchDayId = matchDayId;
    }

    public TeamIdTO getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(TeamIdTO homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public TeamIdTO getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(TeamIdTO awayTeamId) {
        this.awayTeamId = awayTeamId;
    }
}
