package de.tipit.server.transfer.access;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "invoke")
public class MetaDataAdminInvocation {

    @Element(required = true, name = "task")
    private final MetaDataAdminTask task;

    public MetaDataAdminInvocation(@Element(name = "task") MetaDataAdminTask task) {
        this.task = task;
    }

    public MetaDataAdminTask getTask() {
        return task;
    }
}
