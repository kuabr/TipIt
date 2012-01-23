package de.tipit.server.transfer.data;

import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "Tournament")
public class TournamentTO extends TournamentDataResultTO {

    @ElementList(required = false)
    private List<TournamentRoundDataArgumentTO> tournRounds;

    @ElementList(required = false)
    private List<BetCommunityNameTO> betCommunities;

    @Element(required = false)
    private UserNameTO creator;

    @ElementList(required = false)
    private List<UserNameTO> moderators;

    @ElementList(required = false)
    private List<CommentTO> comments;

    @Element(required = false)
    private Date creation;

    @Element(required = false)
    private Date deleted;

    public List<TournamentRoundDataArgumentTO> getTournRounds() {
        return tournRounds;
    }

    public void setTournRounds(List<TournamentRoundDataArgumentTO> tournRounds) {
        this.tournRounds = tournRounds;
    }

    public List<BetCommunityNameTO> getBetCommunities() {
        return betCommunities;
    }

    public void setBetCommunities(List<BetCommunityNameTO> betCommunities) {
        this.betCommunities = betCommunities;
    }

    public UserNameTO getCreator() {
        return creator;
    }

    public void setCreator(UserNameTO creator) {
        this.creator = creator;
    }

    public List<UserNameTO> getModerators() {
        return moderators;
    }

    public void setModerators(List<UserNameTO> moderators) {
        this.moderators = moderators;
    }

    public List<CommentTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentTO> comments) {
        this.comments = comments;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }
}
