package org.unibl.etf.epopis.app.users;

import org.unibl.etf.epopis.model.actors.Administrator;
import org.unibl.etf.epopis.model.reflection.factories.AdministratorFactory;
import org.unibl.etf.epopis.db.querying.SQLDriver;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserAdministrator implements Loginnable {
    @NonNull private String username;
    private Administrator entity;

    public boolean exists(Object id) {
        SQLDriver<Administrator> driver = new SQLDriver<>(new AdministratorFactory());
        Administrator result = driver.read(id);

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
        return this.username;
    }
}
