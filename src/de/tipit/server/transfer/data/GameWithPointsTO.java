package de.tipit.server.transfer.data;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "GameWithPoints")
public class GameWithPointsTO extends GameTO {

    @ElementList(required = false)
    private List<Integer> points;

    public List<Integer> getPoints() {
        return points;
    }

    public void setPoints(List<Integer> points) {
        this.points = points;
    }
}
