package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "TournamentDataResult")
public class TournamentDataResultTO extends TournamentDataBaseTO {

    @Element(required = false)
    private TournamentTypeNameTO tournTypeName;

    @Element(required = false)
    private TeamNameTO winnerTeamName;

    public TournamentTypeNameTO getTournTypeName() {
        return tournTypeName;
    }

    public void setTournTypeName(TournamentTypeNameTO tournTypeName) {
        this.tournTypeName = tournTypeName;
    }

    public TeamNameTO getWinnerTeamName() {
        return winnerTeamName;
    }

    public void setWinnerTeamName(TeamNameTO winnerTeamName) {
        this.winnerTeamName = winnerTeamName;
    }
}
