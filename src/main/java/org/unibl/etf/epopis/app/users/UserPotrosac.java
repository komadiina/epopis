package org.unibl.etf.epopis.app.users;


import org.unibl.etf.epopis.model.actors.Potrosac;
import org.unibl.etf.epopis.model.exceptions.RegisterException;
import org.unibl.etf.epopis.model.reflection.factories.PotrosacFactory;
import org.unibl.etf.epopis.db.querying.SQLDriver;
import lombok.*;

import java.sql.SQLException;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserPotrosac implements Loginnable {
    @NonNull private String pib;
    private Potrosac entity;

    public static boolean exists(Object id) {
        SQLDriver<Potrosac> driver = new SQLDriver<>(new PotrosacFactory());
        Potrosac result = null;
        try {
            result = driver.read(id);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
        return result != null;
    }

    public static boolean register(String pib, String naziv, String posta, String telefon, String lozinka, Integer idDistributer) throws RegisterException {
        if (UserPotrosac.exists(pib))
            throw new RegisterException("User already exists!");

        Potrosac entry = new Potrosac(pib, naziv, posta, telefon, lozinka, idDistributer);
        SQLDriver<Potrosac> driver = new SQLDriver<>(new PotrosacFactory());
        try {
            return driver.create(entry) != -1;
        } catch (SQLException ex) {
            throw new RegisterException(ex.getMessage());
        }
    }

    @Override
    public boolean login(String username, String password) {
        return true;
    }

    @Override
    public String fetchUsername() {
        return this.pib;
    }
}
