package org.unibl.etf.epopis.app.users;


import org.unibl.etf.epopis.model.actors.Potrosac;
import org.unibl.etf.epopis.model.reflection.factories.PotrosacFactory;
import org.unibl.etf.epopis.db.querying.SQLDriver;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserPotrosac implements Loginnable {
    @NonNull private String pib;
    private Potrosac entity;

    public boolean exists(Object id) {
        SQLDriver<Potrosac> driver = new SQLDriver<>(new PotrosacFactory());
        Potrosac result = driver.read(id);

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
        return this.pib;
    }
}
