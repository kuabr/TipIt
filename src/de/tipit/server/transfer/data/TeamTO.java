package de.tipit.server.transfer.data;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "Team")
public class TeamTO extends TeamDataTO {

    @ElementList(required = false)
    private List<TournamentTypeNameTO> allowedTournTypes;

    @ElementList(required = false)
    private List<GameResultDataTO> homeGames;

    @ElementList(required = false)
    private List<GameResultDataTO> awayGames;

    @ElementList(required = false)
    private List<TournamentDescrTO> wonTournaments;

    public List<TournamentTypeNameTO> getAllowedTournTypes() {
        return allowedTournTypes;
    }

    public void setAllowedTournTypes(List<TournamentTypeNameTO> allowedTournTypes) {
        this.allowedTournTypes = allowedTournTypes;
    }

    public List<GameResultDataTO> getHomeGames() {
        return homeGames;
    }

    public void setHomeGames(List<GameResultDataTO> homeGames) {
        this.homeGames = homeGames;
    }

    public List<GameResultDataTO> getAwayGames() {
        return awayGames;
    }

    public void setAwayGames(List<GameResultDataTO> awayGames) {
        this.awayGames = awayGames;
    }

    public List<TournamentDescrTO> getWonTournaments() {
        return wonTournaments;
    }

    public void setWonTournaments(List<TournamentDescrTO> wonTournaments) {
        this.wonTournaments = wonTournaments;
    }
}
