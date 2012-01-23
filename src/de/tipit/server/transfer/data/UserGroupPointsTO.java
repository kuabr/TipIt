package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "UserGroupPoints")
public class UserGroupPointsTO extends UserGroupIdTO {

    @Element(required = false)
    private Float averageUserPoints;

    @Element(required = false)
    private Float averageNrOfBets;

    public Float getAverageUserPoints() {
        return averageUserPoints;
    }

    public void setAverageUserPoints(Float averageUserPoints) {
        this.averageUserPoints = averageUserPoints;
    }

    public Float getAverageNrOfBets() {
        return averageNrOfBets;
    }

    public void setAverageNrOfBets(Float averageNrOfBets) {
        this.averageNrOfBets = averageNrOfBets;
    }
}
