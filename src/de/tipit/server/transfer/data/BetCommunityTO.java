package de.tipit.server.transfer.data;

import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "BetCommunity")
public class BetCommunityTO extends BetCommunityDataResultTO {

    @ElementList(required = false)
    private List<UserGroupNameTO> userGroups;

    @ElementList(required = false)
    private List<TournamentDescrTO> tournaments;

    @Element(required = false)
    private UserNameTO founder;

    @ElementList(required = false)
    private List<UserNameTO> moderators;

    @Element(required = false)
    private Date foundation;

    @Element(required = false)
    private Date deleted;

    public List<UserGroupNameTO> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroupNameTO> userGroups) {
        this.userGroups = userGroups;
    }

    public List<TournamentDescrTO> getTournaments() {
        return tournaments;
    }

    public void setTournaments(List<TournamentDescrTO> tournaments) {
        this.tournaments = tournaments;
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
