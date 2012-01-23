package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "TournamentDataArgument")
public class TournamentDataArgumentTO extends TournamentDataBaseTO {

    @Element(required = false)
    private TournamentTypeIdTO tournTypeId;

    @Element(required = false)
    private TeamIdTO winnerTeamId;

    public TournamentTypeIdTO getTournTypeId() {
        return tournTypeId;
    }

    public void setTournTypeId(TournamentTypeIdTO tournTypeId) {
        this.tournTypeId = tournTypeId;
    }

    public TeamIdTO getWinnerTeamId() {
        return winnerTeamId;
    }

    public void setWinnerTeamId(TeamIdTO winnerTeamId) {
        this.winnerTeamId = winnerTeamId;
    }
}
