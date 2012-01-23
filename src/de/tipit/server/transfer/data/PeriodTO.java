package de.tipit.server.transfer.data;

import java.util.Date;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Period")
public class PeriodTO {

    @Element(required = false)
    private Date first;

    @Element(required = false)
    private Date last;

    public Date getFirst() {
        return first;
    }

    public void setFirst(Date first) {
        this.first = first;
    }

    public Date getLast() {
        return last;
    }

    public void setLast(Date last) {
        this.last = last;
    }
}
