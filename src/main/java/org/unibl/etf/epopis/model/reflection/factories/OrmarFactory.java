package org.unibl.etf.epopis.model.reflection.factories;

import org.unibl.etf.epopis.model.actors.Ormar;
import org.unibl.etf.epopis.model.reflection.Factory;
import org.unibl.etf.epopis.model.exceptions.InvalidPrimaryKeyTypeException;

public class OrmarFactory implements Factory<Ormar> {
    @Override
    public Ormar create(Object primaryKey) {
        if (primaryKey instanceof String)
            return new Ormar((String) primaryKey);
        else throw new InvalidPrimaryKeyTypeException("Ormar expects 'primaryKey' to be of type 'String'.");
    }

    @Override
    public Ormar create() {
        return new Ormar();
    }
}
