package de.tipit.server.transfer.access;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "invoke")
public class TournamentAdminInvocation {

    @Element(required = true, name = "task")
    private final TournamentAdminTask task;

    public TournamentAdminInvocation(@Element(name = "task") TournamentAdminTask task) {
        this.task = task;
    }

    public TournamentAdminTask getTask() {
        return task;
    }
}
