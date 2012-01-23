package de.tipit.server.transfer.data;

import java.util.Date;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "UserData")
public class UserDataTO extends UserIdTO {

    public static enum Gender {
        FEMALE, MALE
    }

    @Element(required = false)
    private UserAccountTO account;

    @Element(required = false)
    private UserContactTO contact;

    @Element(required = false)
    private String fullPreName;

    @Element(required = false)
    private String fullSurName;

    @Element(required = false)
    private Gender gender;

    @Element(required = false)
    private Date birthday;

    public UserAccountTO getAccount() {
        return account;
    }

    public void setAccount(UserAccountTO account) {
        this.account = account;
    }

    public UserContactTO getContact() {
        return contact;
    }

    public void setContact(UserContactTO contact) {
        this.contact = contact;
    }

    public String getFullPreName() {
        return fullPreName;
    }

    public void setFullPreName(String fullPreName) {
        this.fullPreName = fullPreName;
    }

    public String getFullSurName() {
        return fullSurName;
    }

    public void setFullSurName(String fullSurName) {
        this.fullSurName = fullSurName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
