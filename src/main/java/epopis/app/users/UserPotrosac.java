package epopis.app.users;


import epopis.model.actors.Potrosac;
import epopis.model.reflection.factories.PotrosacFactory;
import epopis.db.querying.SQLDriver;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserPotrosac {
    @NonNull private String pib;
    private Potrosac entity;

    public boolean exists(Object id) {
        SQLDriver<Potrosac> driver = new SQLDriver<>(new PotrosacFactory());
        Potrosac result = driver.read(id);

        if (result != null)
            this.entity = result;

        return result != null;
    }
}
