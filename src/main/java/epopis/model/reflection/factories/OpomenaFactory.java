package epopis.model.reflection.factories;

import epopis.model.actors.Dokument;
import epopis.model.actors.Opomena;
import epopis.model.reflection.Factory;
import epopis.model.reflection.exceptions.InvalidPrimaryKeyTypeException;

public class OpomenaFactory implements Factory<Dokument> {
    @Override
    public Opomena create(Object primaryKey) {
        if (primaryKey instanceof Integer)
            return new Opomena((Integer) primaryKey);
        else throw new InvalidPrimaryKeyTypeException("Opomena expects 'primaryKey' to be of type 'Integer'.");
    }

    @Override
    public Dokument create() {
        return new Opomena();
    }
}
