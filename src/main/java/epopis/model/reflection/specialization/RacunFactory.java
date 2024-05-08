package epopis.model.reflection.specialization;

import epopis.model.actors.Racun;
import epopis.model.reflection.Factory;
import epopis.model.reflection.InvalidPrimaryKeyType;

public class RacunFactory implements Factory<Racun> {
    @Override
    public Racun create(Object primaryKey) {
        if (primaryKey instanceof Integer)
            return new Racun((Integer) primaryKey);
        else throw new InvalidPrimaryKeyType("Racun expects 'primaryKey' to be of type 'Integer'.");
    }
}
