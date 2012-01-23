package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "TournamentRoundDataResult")
public class TournamentRoundDataResultTO extends TournamentRoundDataBaseTO {

    @Element(required = false)
    private TournamentDescrTO tournDescr;

    public TournamentDescrTO getTournDescr() {
        return tournDescr;
    }

    public void setTournDescr(TournamentDescrTO tournDescr) {
        this.tournDescr = tournDescr;
    }
}
