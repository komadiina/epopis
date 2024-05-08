package epopis.driver.users;

import epopis.model.actors.Knjigovodja;
import epopis.model.reflection.specialization.KnjigovodjaFactory;
import epopis.model.util.SQLDriver;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserKnjigovodja {
    private String jmbg;
    Knjigovodja entity;

    public boolean exists(Object id) {
        SQLDriver<Knjigovodja> driver = new SQLDriver<>(new KnjigovodjaFactory());
        Knjigovodja result = driver.read(id);

        if (result != null)
            this.entity = result;

        return result != null;
    }
}
