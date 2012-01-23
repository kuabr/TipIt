package de.tipit.server.transfer.data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "UserAccount")
public class UserAccountTO {

    @Attribute(required = false)
    private String userName;

    @Attribute(required = false)
    private String password;

    public static byte[] encryptPassword(String readablePassword) {
        MessageDigest digest;
        try {
            digest = java.security.MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException exc) {
            return readablePassword.getBytes(); // do not encrypt :-(
        }
        digest.update(readablePassword.getBytes());
        return digest.digest();
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getEncryptedPassword() {
        return encryptPassword(password);
    }
}
