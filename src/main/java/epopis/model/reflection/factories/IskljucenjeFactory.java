package epopis.model.reflection.factories;

import epopis.model.actors.Iskljucenje;
import epopis.model.reflection.Factory;
import epopis.model.reflection.exceptions.InvalidPrimaryKeyTypeException;

public class IskljucenjeFactory implements Factory<Iskljucenje> {
    @Override
    public Iskljucenje create(Object primaryKey) {
        if (primaryKey instanceof Integer)
            return new Iskljucenje((Integer) primaryKey);
        else throw new InvalidPrimaryKeyTypeException("Iskljucenje expects 'primaryKey' to be of type 'Integer'.");
    }

    @Override
    public Iskljucenje create() {
        return new Iskljucenje();
    }
}
