package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import de.tipit.server.transfer.data.UserDataTO.Gender;

@Root(name = "UserSearchData")
public class UserSearchDataTO extends GeneralSearchData {

    @Element(required = false)
    private Gender gender;

    @Element(required = false)
    private Boolean isInactive;

    @Element(required = false)
    private Boolean isDisabled;

    @Element(required = false)
    private Boolean isAdmin;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Boolean getIsInactive() {
        return isInactive;
    }

    public void setIsInactive(Boolean isInactive) {
        this.isInactive = isInactive;
    }

    public Boolean getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(Boolean isDisabled) {
        this.isDisabled = isDisabled;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
