package de.tipit.server.transfer.data;

import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "GameResult")
public class GameResultTO extends GameResultDataTO {

    @ElementList(required = false)
    private List<CommentTO> comments;

    @Element(required = false)
    private UserNameTO creator;

    @Element(required = false)
    private Date creation;

    public List<CommentTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentTO> comments) {
        this.comments = comments;
    }

    public UserNameTO getCreator() {
        return creator;
    }

    public void setCreator(UserNameTO creator) {
        this.creator = creator;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }
}
