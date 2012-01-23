package de.tipit.server.transfer.data;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "MatchDayDataBase")
public class MatchDayDataBaseTO extends MatchDayIdTO {

    @Attribute(required = false)
    private Integer day;

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}
