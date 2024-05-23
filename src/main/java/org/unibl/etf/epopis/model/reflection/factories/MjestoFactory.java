package org.unibl.etf.epopis.model.reflection.factories;

import org.unibl.etf.epopis.model.actors.Mjesto;
import org.unibl.etf.epopis.model.reflection.Factory;
import org.unibl.etf.epopis.model.exceptions.InvalidPrimaryKeyTypeException;

public class MjestoFactory implements Factory<Mjesto> {
    @Override
    public Mjesto create(Object primaryKey) {
        if (primaryKey instanceof String)
            return new Mjesto((String) primaryKey);
        else throw new InvalidPrimaryKeyTypeException("Mjesto expects 'primaryKey' to be of type 'String'.");
    }

    @Override
    public Mjesto create() {
        return new Mjesto();
    }
}
