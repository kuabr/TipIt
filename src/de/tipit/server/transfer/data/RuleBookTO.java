package de.tipit.server.transfer.data;

import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "RuleBook")
public class RuleBookTO extends RuleBookDataTO {

    @ElementList(required = false)
    private List<BetCommunityNameTO> betCommunities;

    @Element(required = false)
    private UserNameTO creator;

    @Element(required = false)
    private Date created;

    @ElementList(required = false)
    private List<CommentTO> comments;

    @Element(required = false)
    private Date finalized;

    @Element(required = false)
    private Date deleted;

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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<CommentTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentTO> comments) {
        this.comments = comments;
    }

    public Date getFinalized() {
        return finalized;
    }

    public void setFinalized(Date finalized) {
        this.finalized = finalized;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }
}
