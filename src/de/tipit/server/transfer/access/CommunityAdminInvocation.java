package de.tipit.server.transfer.access;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "invoke")
public class CommunityAdminInvocation {

    @Element(required = true, name = "task")
    private final CommunityAdminTask task;

    public CommunityAdminInvocation(@Element(name = "task") CommunityAdminTask task) {
        this.task = task;
    }

    public CommunityAdminTask getTask() {
        return task;
    }
}
