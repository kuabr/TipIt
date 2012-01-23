package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "TeamData")
public class TeamDataTO extends TeamIdTO {

    @Element(required = false)
    private String teamAbbrev;

    @Element(required = false)
    private String teamName;

    public String getTeamAbbrev() {
        return teamAbbrev;
    }

    public void setTeamAbbrev(String teamAbbrev) {
        this.teamAbbrev = teamAbbrev;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
