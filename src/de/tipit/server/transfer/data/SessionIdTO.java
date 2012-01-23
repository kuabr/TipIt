package de.tipit.server.transfer.data;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "SessionId")
public class SessionIdTO {

    @Attribute(required = false)
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
