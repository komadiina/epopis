package epopis.model.reflection.factories;

import epopis.model.actors.Prikljucenje;
import epopis.model.reflection.Factory;
import epopis.model.reflection.exceptions.InvalidPrimaryKeyTypeException;

public class PrikljucenjeFactory implements Factory<Prikljucenje> {
    @Override
    public Prikljucenje create(Object primaryKey) {
        if (primaryKey instanceof Integer)
            return new Prikljucenje((Integer) primaryKey);
        else throw new InvalidPrimaryKeyTypeException("Prikljucenje expects 'primaryKey' to be of type 'Integer'.");
    }

    @Override
    public Prikljucenje create() {
        return new Prikljucenje();
    }
}
