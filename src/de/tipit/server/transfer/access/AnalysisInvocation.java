package de.tipit.server.transfer.access;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "invoke")
public class AnalysisInvocation {

    @Element(required = true, name = "task")
    private final AnalysisTask task;

    public AnalysisInvocation(@Element(name = "task") AnalysisTask task) {
        this.task = task;
    }

    public AnalysisTask getTask() {
        return task;
    }
}
