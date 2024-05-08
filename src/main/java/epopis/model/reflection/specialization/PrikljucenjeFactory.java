package epopis.model.reflection.specialization;

import epopis.model.actors.Prikljucenje;
import epopis.model.reflection.Factory;
import epopis.model.reflection.InvalidPrimaryKeyType;

public class PrikljucenjeFactory implements Factory<Prikljucenje> {
    @Override
    public Prikljucenje create(Object primaryKey) {
        if (primaryKey instanceof Integer)
            return new Prikljucenje((Integer) primaryKey);
        else throw new InvalidPrimaryKeyType("Prikljucenje expects 'primaryKey' to be of type 'Integer'.");
    }
}
