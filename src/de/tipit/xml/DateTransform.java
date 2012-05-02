package de.tipit.xml;

import java.util.Date;

import org.simpleframework.xml.transform.Transform;

public class DateTransform implements Transform<Date> {

    @Override
    public Date read(String value) throws Exception {
        long time = Long.valueOf(value);
        return new Date(time);
    }

    @Override
    public String write(Date value) throws Exception {
        return String.valueOf(value.getTime());
    }
}
