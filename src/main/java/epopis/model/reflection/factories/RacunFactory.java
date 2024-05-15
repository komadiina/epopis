package epopis.model.reflection.factories;

import epopis.model.actors.Racun;
import epopis.model.reflection.Factory;
import epopis.model.reflection.exceptions.InvalidPrimaryKeyTypeException;

public class RacunFactory implements Factory<Racun> {
    @Override
    public Racun create(Object primaryKey) {
        if (primaryKey instanceof Integer)
            return new Racun((Integer) primaryKey);
        else throw new InvalidPrimaryKeyTypeException("Racun expects 'primaryKey' to be of type 'Integer'.");
    }

    @Override
    public Racun create() {
        return new Racun();
    }
}
