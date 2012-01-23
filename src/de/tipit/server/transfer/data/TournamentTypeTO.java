package de.tipit.server.transfer.data;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "TournamentType")
public class TournamentTypeTO extends TournamentTypeDataResultTO {

    @ElementList(required = false)
    private List<TournamentDescrTO> tournaments;

    @ElementList(required = false)
    private List<TeamNameTO> allowedTeams;

    public List<TournamentDescrTO> getTournaments() {
        return tournaments;
    }

    public void setTournaments(List<TournamentDescrTO> tournaments) {
        this.tournaments = tournaments;
    }

    public List<TeamNameTO> getAllowedTeams() {
        return allowedTeams;
    }

    public void setAllowedTeams(List<TeamNameTO> allowedTeams) {
        this.allowedTeams = allowedTeams;
    }
}
