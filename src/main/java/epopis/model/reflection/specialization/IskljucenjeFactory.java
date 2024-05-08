package epopis.model.reflection.specialization;

import epopis.model.actors.Iskljucenje;
import epopis.model.reflection.Factory;
import epopis.model.reflection.InvalidPrimaryKeyType;

public class IskljucenjeFactory implements Factory<Iskljucenje> {
    @Override
    public Iskljucenje create(Object primaryKey) {
        if (primaryKey instanceof Integer)
            return new Iskljucenje((Integer) primaryKey);
        else throw new InvalidPrimaryKeyType("Iskljucenje expects 'primaryKey' to be of type 'Integer'.");
    }
}
