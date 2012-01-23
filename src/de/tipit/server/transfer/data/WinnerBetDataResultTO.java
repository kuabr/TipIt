package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "WinnerBetDataResult")
public class WinnerBetDataResultTO extends WinnerBetIdTO {

    @Element(required = false)
    private TournamentDescrTO tournDescr;

    @Element(required = false)
    private TeamNameTO winnerTeamName;

    public TournamentDescrTO getTournDescr() {
        return tournDescr;
    }

    public void setTournDescr(TournamentDescrTO tournDescr) {
        this.tournDescr = tournDescr;
    }

    public TeamNameTO getWinnerTeamName() {
        return winnerTeamName;
    }

    public void setWinnerTeamName(TeamNameTO winnerTeamName) {
        this.winnerTeamName = winnerTeamName;
    }
}
