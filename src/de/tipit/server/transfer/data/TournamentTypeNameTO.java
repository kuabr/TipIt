package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "TournamentTypeName")
public class TournamentTypeNameTO extends TournamentTypeIdTO {

    @Element(required = false)
    private String tournTypeName;

    public String getTournTypeName() {
        return tournTypeName;
    }

    public void setTournTypeName(String tournTypeName) {
        this.tournTypeName = tournTypeName;
    }
}
