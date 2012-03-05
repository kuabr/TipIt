package de.tipit.helper;

import de.tipit.server.transfer.data.SessionTO;

public class SessionContainer {

    private static SessionTO session = null;

    public static synchronized void setSession(SessionTO session) {
        SessionContainer.session = session;
    }

    public static synchronized boolean hasSession() {
        return SessionContainer.session != null;
    }

    public static synchronized SessionTO getSession() {
        if (SessionContainer.session != null) {
            return SessionContainer.session;
        } else {
            return new SessionTO();
        }
    }
}
