package org.unibl.etf.epopis.app.users;

import org.unibl.etf.epopis.model.actors.Snabdjevac;

public class UserSnabdjevac implements Loginnable{
    private String id;
    private Snabdjevac entity;

    @Override
    public boolean login(String username, String password) {
        return true;
    }

    @Override
    public String fetchUsername() {
        return this.id;
    }
}
