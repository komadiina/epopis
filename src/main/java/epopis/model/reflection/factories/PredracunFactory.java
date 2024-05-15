package epopis.model.reflection.factories;

import epopis.model.actors.Predracun;
import epopis.model.reflection.Factory;
import epopis.model.reflection.exceptions.InvalidPrimaryKeyTypeException;

public class PredracunFactory implements Factory<Predracun> {
    @Override
    public Predracun create(Object primaryKey) {
        if (primaryKey instanceof Integer)
            return new Predracun((Integer) primaryKey);
        else throw new InvalidPrimaryKeyTypeException("Predracun expects 'primaryKey' to be of type 'Integer'.");
    }

    @Override
    public Predracun create() {
        return new Predracun();
    }
}