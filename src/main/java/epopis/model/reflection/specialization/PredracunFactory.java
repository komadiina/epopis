package epopis.model.reflection.specialization;

import epopis.model.actors.Predracun;
import epopis.model.reflection.Factory;
import epopis.model.reflection.InvalidPrimaryKeyType;

public class PredracunFactory implements Factory<Predracun> {
    @Override
    public Predracun create(Object primaryKey) {
        if (primaryKey instanceof Integer)
            return new Predracun((Integer) primaryKey);
        else throw new InvalidPrimaryKeyType("Predracun expects 'primaryKey' to be of type 'Integer'.");
    }
}
