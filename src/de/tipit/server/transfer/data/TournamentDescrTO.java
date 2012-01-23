package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "TournamentDescr")
public class TournamentDescrTO extends TournamentIdTO {

    @Element(required = false)
    private String displayDescr;

    public String getDisplayDescr() {
        return displayDescr;
    }

    public void setDisplayDescr(String displayDescr) {
        this.displayDescr = displayDescr;
    }
}
