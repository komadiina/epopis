package org.unibl.etf.epopis.model.reflection.factories;

import org.unibl.etf.epopis.model.actors.Snabdjevac;
import org.unibl.etf.epopis.model.reflection.Factory;
import org.unibl.etf.epopis.model.exceptions.InvalidPrimaryKeyTypeException;

public class SnabdjevacFactory implements Factory<Snabdjevac> {
    @Override
    public Snabdjevac create(Object primaryKey) {
        if (primaryKey instanceof Integer)
            return new Snabdjevac((Integer) primaryKey);
        else throw new InvalidPrimaryKeyTypeException("Snabdjevac expects 'primaryKey' to be of type 'Integer'.");
    }

    @Override
    public Snabdjevac create() {
        return new Snabdjevac();
    }
}
