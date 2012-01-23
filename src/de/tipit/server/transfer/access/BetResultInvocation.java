package de.tipit.server.transfer.access;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "invoke")
public class BetResultInvocation {

    @Element(required = true, name = "task")
    private final BetResultTask task;

    public BetResultInvocation(@Element(name = "task") BetResultTask task) {
        this.task = task;
    }

    public BetResultTask getTask() {
        return task;
    }
}
