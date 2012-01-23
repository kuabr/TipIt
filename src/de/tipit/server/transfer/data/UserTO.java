package de.tipit.server.transfer.data;

import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "User")
public class UserTO extends UserDataTO {

    @ElementList(required = false)
    private List<BetCommunityNameTO> betCommunitiesMod;

    @ElementList(required = false)
    private List<UserGroupNameTO> userGroupsMod;

    @ElementList(required = false)
    private List<TournamentDescrTO> tournamentsMod;

    @Element(required = false)
    private Boolean isAdmin;

    @Element(required = false)
    private Boolean isGuest;

    @ElementList(required = false)
    private List<UserGroupNameTO> groups;

    @ElementList(required = false)
    private List<SessionIdTO> sessions;

    @Element(required = false)
    private Date creation;

    @Element(required = false)
    private Date inactive;

    @Element(required = false)
    private Date disabled;

    public List<BetCommunityNameTO> getBetCommunitiesMod() {
        return betCommunitiesMod;
    }

    public void setBetCommunitiesMod(List<BetCommunityNameTO> betCommunitiesMod) {
        this.betCommunitiesMod = betCommunitiesMod;
    }

    public List<UserGroupNameTO> getUserGroupsMod() {
        return userGroupsMod;
    }

    public void setUserGroupsMod(List<UserGroupNameTO> userGroupsMod) {
        this.userGroupsMod = userGroupsMod;
    }

    public List<TournamentDescrTO> getTournamentsMod() {
        return tournamentsMod;
    }

    public void setTournamentsMod(List<TournamentDescrTO> tournamentsMod) {
        this.tournamentsMod = tournamentsMod;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Boolean getIsGuest() {
        return isGuest;
    }

    public void setIsGuest(Boolean isGuest) {
        this.isGuest = isGuest;
    }

    public List<UserGroupNameTO> getGroups() {
        return groups;
    }

    public void setGroups(List<UserGroupNameTO> groups) {
        this.groups = groups;
    }

    public List<SessionIdTO> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionIdTO> sessions) {
        this.sessions = sessions;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getInactive() {
        return inactive;
    }

    public void setInactive(Date inactive) {
        this.inactive = inactive;
    }

    public Date getDisabled() {
        return disabled;
    }

    public void setDisabled(Date disabled) {
        this.disabled = disabled;
    }
}
