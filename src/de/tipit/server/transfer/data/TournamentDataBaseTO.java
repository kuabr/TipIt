package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "TournamentDataBase")
public class TournamentDataBaseTO extends TournamentIdTO {

    @Element(required = false)
    private String tournSaison;

    public String getTournSaison() {
        return tournSaison;
    }

    public void setTournSaison(String tournSaison) {
        this.tournSaison = tournSaison;
    }
}
