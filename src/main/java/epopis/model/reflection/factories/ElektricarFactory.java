package epopis.model.reflection.factories;

import epopis.model.actors.Elektricar;
import epopis.model.reflection.Factory;
import epopis.model.reflection.exceptions.InvalidPrimaryKeyTypeException;

public class ElektricarFactory implements Factory<Elektricar> {
    @Override
    public Elektricar create(Object primaryKey) {
        if (primaryKey instanceof String)
            return new Elektricar((String)primaryKey);
        else throw new InvalidPrimaryKeyTypeException("Elektricar expects 'pk_JMBG' to be of type 'String'.");
    }

    @Override
    public Elektricar create() {
        return new Elektricar();
    }
}
