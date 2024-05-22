package org.unibl.etf.epopis.app.users;

public interface Loginnable {
    String fetchUsername();
    boolean login(String username, String password);
}
