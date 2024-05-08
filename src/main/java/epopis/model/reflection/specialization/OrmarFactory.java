package epopis.model.reflection.specialization;

import epopis.model.actors.Ormar;
import epopis.model.reflection.Factory;
import epopis.model.reflection.InvalidPrimaryKeyType;

public class OrmarFactory implements Factory<Ormar> {
    @Override
    public Ormar create(Object primaryKey) {
        if (primaryKey instanceof String)
            return new Ormar((String) primaryKey);
        else throw new InvalidPrimaryKeyType("Ormar expects 'primaryKey' to be of type 'String'.");
    }
}
