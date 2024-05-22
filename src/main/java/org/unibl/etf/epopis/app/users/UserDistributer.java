package org.unibl.etf.epopis.app.users;

import org.unibl.etf.epopis.model.actors.Distributer;

public class UserDistributer implements Loginnable {
    private String id;
    private Distributer entity;

    @Override
    public boolean login(String username, String password) {
        return true;
    }

    @Override
    public String fetchUsername() {
        return this.id;
    }
}
