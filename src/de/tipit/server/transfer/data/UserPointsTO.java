package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "UserPoints")
public class UserPointsTO extends UserIdTO {

    @Element(required = false)
    private Integer userPoints;

    @Element(required = false)
    private Integer nrOfBets;

    public Integer getUserPoints() {
        return userPoints;
    }

    public void setUserPoints(Integer userPoints) {
        this.userPoints = userPoints;
    }

    public Integer getNrOfBets() {
        return nrOfBets;
    }

    public void setNrOfBets(Integer nrOfBets) {
        this.nrOfBets = nrOfBets;
    }
}
