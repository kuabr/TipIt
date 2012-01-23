package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "LoginParameter")
public class LoginParameterTO {

    public static enum SessionDuration {
        HOUR, DAY, WEEK, MONTH, YEAR, INFINITE
    }

    @Element(required = false)
    private SessionDuration sessionDuration;

    @Element(required = false)
    private Boolean killOldSessions;

    public SessionDuration getSessionDuration() {
        return sessionDuration;
    }

    public void setSessionDuration(SessionDuration sessionDuration) {
        this.sessionDuration = sessionDuration;
    }

    public Boolean getKillOldSessions() {
        return killOldSessions;
    }

    public void setKillOldSessions(Boolean killOldSessions) {
        this.killOldSessions = killOldSessions;
    }
}
