package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "BetCommunityName")
public class BetCommunityNameTO extends BetCommunityIdTO {

    @Element(required = false)
    private String communityName;

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }
}
