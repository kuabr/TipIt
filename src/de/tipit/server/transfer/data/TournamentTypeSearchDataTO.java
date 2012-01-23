package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "TournamentTypeSearchData")
public class TournamentTypeSearchDataTO extends GeneralSearchData {

    @Element(required = false)
    private SportIdTO sportId;

    public SportIdTO getSportId() {
        return sportId;
    }

    public void setSportId(SportIdTO sportId) {
        this.sportId = sportId;
    }
}
