package org.unibl.etf.epopis.app.users;

import org.unibl.etf.epopis.model.actors.Elektricar;
import org.unibl.etf.epopis.model.reflection.factories.ElektricarFactory;
import org.unibl.etf.epopis.db.querying.SQLDriver;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserElektricar implements Loginnable {
    @NonNull private String jmbg;
    private Elektricar entity;

    public boolean exists(Object id) {
        SQLDriver<Elektricar> driver = new SQLDriver<>(new ElektricarFactory());
        Elektricar result = null;
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
