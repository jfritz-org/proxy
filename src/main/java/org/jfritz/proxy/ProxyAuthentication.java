package org.jfritz.proxy;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class ProxyAuthentication extends Authenticator {
    private String username;
    private String passwort;

    public ProxyAuthentication(String username, String passwort) {
        this.username = username;
        this.passwort = passwort;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return (new PasswordAuthentication(this.username, this.passwort
                .toCharArray()));
    }
}
