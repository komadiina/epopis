package epopis.model.reflection.specialization;

import epopis.model.actors.Elektricar;
import epopis.model.reflection.Factory;
import epopis.model.reflection.InvalidPrimaryKeyType;

public class ElektricarFactory implements Factory<Elektricar> {
    @Override
    public Elektricar create(Object primaryKey) {
        if (primaryKey instanceof String)
            return new Elektricar((String)primaryKey);
        else throw new InvalidPrimaryKeyType("Elektricar expects 'pk_JMBG' to be of type 'String'.");
    }
}
