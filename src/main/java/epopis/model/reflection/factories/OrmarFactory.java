package epopis.model.reflection.factories;

import epopis.model.actors.Ormar;
import epopis.model.reflection.Factory;
import epopis.model.reflection.exceptions.InvalidPrimaryKeyTypeException;

public class OrmarFactory implements Factory<Ormar> {
    @Override
    public Ormar create(Object primaryKey) {
        if (primaryKey instanceof String)
            return new Ormar((String) primaryKey);
        else throw new InvalidPrimaryKeyTypeException("Ormar expects 'primaryKey' to be of type 'String'.");
    }

    @Override
    public Ormar create() {
        return new Ormar();
    }
}
