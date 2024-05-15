package epopis.model.reflection.specialization;

import epopis.model.actors.Knjigovodja;
import epopis.model.reflection.Factory;
import epopis.model.reflection.InvalidPrimaryKeyType;

public class KnjigovodjaFactory implements Factory<Knjigovodja> {
    @Override
    public Knjigovodja create(Object primaryKey) {
        if (primaryKey instanceof String)
            return new Knjigovodja((String) primaryKey);
        else throw new InvalidPrimaryKeyType("Knjigovodja expects 'primaryKey' to be of type 'String'.");
    }
}
