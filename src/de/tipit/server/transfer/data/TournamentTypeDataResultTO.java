package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "TournamentTypeDataResult")
public class TournamentTypeDataResultTO extends TournamentTypeDataBaseTO {

    @Element(required = false)
    private SportNameTO sportName;

    public SportNameTO getSportName() {
        return sportName;
    }

    public void setSportName(SportNameTO sportName) {
        this.sportName = sportName;
    }
}
