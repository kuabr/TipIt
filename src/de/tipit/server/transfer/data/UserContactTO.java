package de.tipit.server.transfer.data;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "UserContact")
public class UserContactTO {

    @Attribute(required = false)
    private String mailAddress;

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
}
