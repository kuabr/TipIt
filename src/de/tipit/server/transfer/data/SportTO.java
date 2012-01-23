package de.tipit.server.transfer.data;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "Sport")
public class SportTO extends SportDataTO {

    @ElementList(required = false)
    private List<TournamentTypeNameTO> tournTypes;

    public List<TournamentTypeNameTO> getTournTypes() {
        return tournTypes;
    }

    public void setTournTypes(List<TournamentTypeNameTO> tournTypes) {
        this.tournTypes = tournTypes;
    }
}
