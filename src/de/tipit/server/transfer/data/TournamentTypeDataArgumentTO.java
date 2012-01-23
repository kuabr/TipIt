package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "TournamentTypeDataArgument")
public class TournamentTypeDataArgumentTO extends TournamentTypeDataBaseTO {

    @Element(required = false)
    private SportIdTO sportId;

    public SportIdTO getSportId() {
        return sportId;
    }

    public void setSportId(SportIdTO sportId) {
        this.sportId = sportId;
    }
}
