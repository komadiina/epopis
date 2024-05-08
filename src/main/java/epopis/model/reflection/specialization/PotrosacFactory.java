package epopis.model.reflection.specialization;

import epopis.model.actors.Potrosac;
import epopis.model.reflection.Factory;
import epopis.model.reflection.InvalidPrimaryKeyType;

public class PotrosacFactory implements Factory<Potrosac> {
    @Override
    public Potrosac create(Object primaryKey) {
        if (primaryKey instanceof String)
            return new Potrosac((String) primaryKey);
        else throw new InvalidPrimaryKeyType("Potrosac expects 'primaryKey' to be of type 'String'.");
    }
}
