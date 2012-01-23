package de.tipit.server.transfer.data;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "GeneralId")
public class GeneralId {

    @Attribute(required = false)
    private Long techId;

    public Long getTechId() {
        return techId;
    }

    public void setTechId(Long techId) {
        this.techId = techId;
    }
}
