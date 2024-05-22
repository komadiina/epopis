package org.unibl.etf.epopis.model.reflection.factories;

import org.unibl.etf.epopis.model.actors.Knjigovodja;
import org.unibl.etf.epopis.model.reflection.Factory;
import org.unibl.etf.epopis.model.reflection.exceptions.InvalidPrimaryKeyTypeException;

public class KnjigovodjaFactory implements Factory<Knjigovodja> {
    @Override
    public Knjigovodja create(Object primaryKey) {
        if (primaryKey instanceof String)
            return new Knjigovodja((String) primaryKey);
        else throw new InvalidPrimaryKeyTypeException("Knjigovodja expects 'primaryKey' to be of type 'String'.");
    }

    @Override
    public Knjigovodja create() {
        return new Knjigovodja();
    }
}
