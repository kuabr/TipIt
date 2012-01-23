package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "MatchDayDataArgument")
public class MatchDayDataArgumentTO extends MatchDayDataBaseTO {

    @Element(required = false)
    private TournamentRoundIdTO tournRoundId;

    public TournamentRoundIdTO getTournRoundId() {
        return tournRoundId;
    }

    public void setTournRoundId(TournamentRoundIdTO tournRoundId) {
        this.tournRoundId = tournRoundId;
    }
}
