package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "TournamentRoundDataArgument")
public class TournamentRoundDataArgumentTO extends TournamentRoundDataBaseTO {

    @Element(required = false)
    private TournamentIdTO tournId;

    public TournamentIdTO getTournId() {
        return tournId;
    }

    public void setTournId(TournamentIdTO tournId) {
        this.tournId = tournId;
    }
}
