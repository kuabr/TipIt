package de.tipit.server.transfer.data;

import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "GameBet")
public class GameBetTO extends GameBetDataWithoutGameTO {

    @Element(required = false)
    private UserNameTO user;

    @ElementList(required = false)
    private List<CommentTO> comments;

    @Element(required = false)
    private Date creation;

    public UserNameTO getUser() {
        return user;
    }

    public void setUser(UserNameTO user) {
        this.user = user;
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
}
