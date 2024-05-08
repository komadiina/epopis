package epopis.model.reflection.specialization;

import epopis.model.actors.Dokument;
import epopis.model.actors.Opomena;
import epopis.model.reflection.Factory;
import epopis.model.reflection.InvalidPrimaryKeyType;

public class OpomenaFactory implements Factory<Dokument> {
    @Override
    public Opomena create(Object primaryKey) {
        if (primaryKey instanceof Integer)
            return new Opomena((Integer) primaryKey);
        else throw new InvalidPrimaryKeyType("Opomena expects 'primaryKey' to be of type 'Integer'.");
    }
}
