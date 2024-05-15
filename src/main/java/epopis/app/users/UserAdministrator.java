package epopis.app.users;

import epopis.model.actors.Administrator;
import epopis.model.reflection.factories.AdministratorFactory;
import epopis.db.querying.SQLDriver;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserAdministrator {
    @NonNull private String username;
    private Administrator entity;

    public boolean exists(Object id) {
        SQLDriver<Administrator> driver = new SQLDriver<>(new AdministratorFactory());
        Administrator result = driver.read(id);

        if (result != null)
            this.entity = result;

        return result != null;
    }

    public boolean login(String password) {
        SQLDriver<Administrator> driver = new SQLDriver<>(new AdministratorFactory());
        Administrator result = driver.read(username);

        if (result != null && result.getPassword().equals(password)) {
            this.entity = result;
            return true;
        } else return false;
    }
}
