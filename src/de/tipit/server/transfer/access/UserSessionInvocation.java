package de.tipit.server.transfer.access;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "invoke")
public class UserSessionInvocation {

    @Element(required = true, name = "task")
    private final UserSessionTask task;

    public UserSessionInvocation(@Element(name = "task") UserSessionTask task) {
        this.task = task;
    }

    public UserSessionTask getTask() {
        return task;
    }
}
