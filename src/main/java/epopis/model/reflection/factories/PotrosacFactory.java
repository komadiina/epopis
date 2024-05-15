package epopis.model.reflection.factories;

import epopis.model.actors.Potrosac;
import epopis.model.reflection.Factory;
import epopis.model.reflection.exceptions.InvalidPrimaryKeyTypeException;

public class PotrosacFactory implements Factory<Potrosac> {
    @Override
    public Potrosac create(Object primaryKey) {
        if (primaryKey instanceof String)
            return new Potrosac((String) primaryKey);
        else throw new InvalidPrimaryKeyTypeException("Potrosac expects 'primaryKey' to be of type 'String'.");
    }

    @Override
    public Potrosac create() {
        return new Potrosac();
    }
}
