package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "MatchDayDescr")
public class MatchDayDescrTO extends MatchDayIdTO {

    @Element(required = false)
    private String displayDescr;

    public String getDisplayDescr() {
        return displayDescr;
    }

    public void setDisplayDescr(String displayDescr) {
        this.displayDescr = displayDescr;
    }
}
