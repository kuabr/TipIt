package de.tipit.xml;

import java.util.Date;

import org.simpleframework.xml.transform.RegistryMatcher;
import org.simpleframework.xml.transform.Transform;

public class Matcher implements org.simpleframework.xml.transform.Matcher {

    private final RegistryMatcher regMatcher;

    public Matcher() {
        this.regMatcher = new RegistryMatcher();
        this.regMatcher.bind(Date.class, new DateTransform());
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Transform match(Class type) throws Exception {
        return this.regMatcher.match(type);
    }
}
