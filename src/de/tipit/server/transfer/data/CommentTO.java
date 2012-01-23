package de.tipit.server.transfer.data;

import java.util.Date;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import de.tipit.server.transfer.data.ContextTO.Language;

@Root(name = "Comment")
public class CommentTO extends CommentDataTO {

    @Element(required = false)
    private UserNameTO user;

    @Element(required = false)
    private Language lang;

    @Element(required = false)
    private Date creation;

    @Element(required = false)
    private Date modified;

    @Element(required = false)
    private Date deleted;

    public UserNameTO getUser() {
        return user;
    }

    public void setUser(UserNameTO user) {
        this.user = user;
    }

    public Language getLang() {
        return lang;
    }

    public void setLang(Language lang) {
        this.lang = lang;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }
}
