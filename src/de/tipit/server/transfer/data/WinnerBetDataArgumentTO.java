package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "WinnerBetDataArgument")
public class WinnerBetDataArgumentTO extends WinnerBetIdTO {

    @Element(required = false)
    private TournamentIdTO tournId;

    @Element(required = false)
    private TeamIdTO winnerTeamId;

    public TournamentIdTO getTournId() {
        return tournId;
    }

    public void setTournId(TournamentIdTO tournId) {
        this.tournId = tournId;
    }

    public TeamIdTO getWinnerTeamId() {
        return winnerTeamId;
    }

    public void setWinnerTeamId(TeamIdTO winnerTeamId) {
        this.winnerTeamId = winnerTeamId;
    }
}
