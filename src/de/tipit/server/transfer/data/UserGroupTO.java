package de.tipit.server.transfer.data;

import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "UserGroup")
public class UserGroupTO extends UserGroupDataTO {

    @ElementList(required = false)
    private List<BetCommunityNameTO> betCommunities;

    @ElementList(required = false)
    private List<UserNameTO> users;

    @Element(required = false)
    private UserNameTO founder;

    @ElementList(required = false)
    private List<UserNameTO> moderators;

    @Element(required = false)
    private Date foundation;

    @Element(required = false)
    private Date deleted;

    public List<BetCommunityNameTO> getBetCommunities() {
        return betCommunities;
    }

    public void setBetCommunities(List<BetCommunityNameTO> betCommunities) {
        this.betCommunities = betCommunities;
    }

    public List<UserNameTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserNameTO> users) {
        this.users = users;
    }

    public UserNameTO getFounder() {
        return founder;
    }

    public void setFounder(UserNameTO founder) {
        this.founder = founder;
    }

    public List<UserNameTO> getModerators() {
        return moderators;
    }

    public void setModerators(List<UserNameTO> moderators) {
        this.moderators = moderators;
    }

    public Date getFoundation() {
        return foundation;
    }

    public void setFoundation(Date foundation) {
        this.foundation = foundation;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }
}
