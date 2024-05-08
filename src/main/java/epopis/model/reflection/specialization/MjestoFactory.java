package epopis.model.reflection.specialization;

import epopis.model.actors.Mjesto;
import epopis.model.reflection.Factory;
import epopis.model.reflection.InvalidPrimaryKeyType;

public class MjestoFactory implements Factory<Mjesto> {
    @Override
    public Mjesto create(Object primaryKey) {
        if (primaryKey instanceof String)
            return new Mjesto((String) primaryKey);
        else throw new InvalidPrimaryKeyType("Mjesto expects 'primaryKey' to be of type 'String'.");
    }
}
