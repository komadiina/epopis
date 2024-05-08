package epopis.driver.users;

import epopis.model.actors.Elektricar;
import epopis.model.reflection.specialization.ElektricarFactory;
import epopis.model.util.SQLDriver;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserElektricar {
    @NonNull private String jmbg;
    private Elektricar entity;

    public boolean exists(Object id) {
        SQLDriver<Elektricar> driver = new SQLDriver<>(new ElektricarFactory());
        Elektricar result = driver.read(id);

        if (result != null)
            this.entity = result;

        return result != null;
    }
}
