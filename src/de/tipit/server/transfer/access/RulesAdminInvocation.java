package de.tipit.server.transfer.access;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "invoke")
public class RulesAdminInvocation {

    @Element(required = true, name = "task")
    private final RulesAdminTask task;

    public RulesAdminInvocation(@Element(name = "task") RulesAdminTask task) {
        this.task = task;
    }

    public RulesAdminTask getTask() {
        return task;
    }
}
