package org.unibl.etf.epopis.model.reflection.factories;

import org.unibl.etf.epopis.model.actors.Potrosac;
import org.unibl.etf.epopis.model.reflection.Factory;
import org.unibl.etf.epopis.model.reflection.exceptions.InvalidPrimaryKeyTypeException;

public class PotrosacFactory implements Factory<Potrosac> {
    @Override
    public Potrosac create(Object primaryKey) {
        if (primaryKey instanceof String)
            return new Potrosac((String) primaryKey);
        else throw new InvalidPrimaryKeyTypeException("Potrosac expects 'primaryKey' to be of type 'String'.");
    }

    @Override
    public Potrosac create() {
        return new Potrosac();
    }
}
