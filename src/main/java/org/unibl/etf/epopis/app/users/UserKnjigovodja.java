package org.unibl.etf.epopis.app.users;

import org.unibl.etf.epopis.model.actors.Knjigovodja;
import org.unibl.etf.epopis.model.reflection.factories.KnjigovodjaFactory;
import org.unibl.etf.epopis.db.querying.SQLDriver;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserKnjigovodja implements Loginnable {
    private String jmbg;
    Knjigovodja entity;

    public boolean exists(Object id) {
        SQLDriver<Knjigovodja> driver = new SQLDriver<>(new KnjigovodjaFactory());
        Knjigovodja result = null;
        try {
            result = driver.read(id);
        } catch (java.sql.SQLException throwables) {
            throw new RuntimeException(throwables);
        }

        if (result != null)
            this.entity = result;

        return result != null;
    }

    @Override
    public boolean login(String username, String password) {
        return true;
    }

    @Override
    public String fetchUsername() {
        return this.jmbg;
    }
}
