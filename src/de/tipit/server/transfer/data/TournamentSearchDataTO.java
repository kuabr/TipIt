package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "TournamentSearchData")
public class TournamentSearchDataTO extends TournamentTypeSearchDataTO {

    @Element(required = false)
    private String tournSaisonSearchText;

    public String getTournSaisonSearchText() {
        return tournSaisonSearchText;
    }

    public void setTournSaisonSearchText(String tournSaisonSearchText) {
        this.tournSaisonSearchText = tournSaisonSearchText;
    }
}
