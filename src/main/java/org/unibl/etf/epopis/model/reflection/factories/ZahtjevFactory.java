package org.unibl.etf.epopis.model.reflection.factories;

import org.unibl.etf.epopis.model.actors.Zahtjev;
import org.unibl.etf.epopis.model.reflection.Factory;
import org.unibl.etf.epopis.model.reflection.exceptions.InvalidPrimaryKeyTypeException;

public class ZahtjevFactory implements Factory<Zahtjev> {
    @Override
    public Zahtjev create(Object primaryKey) {
        if (primaryKey instanceof Integer)
            return new Zahtjev((Integer) primaryKey);
        else throw new InvalidPrimaryKeyTypeException("Zahtjev expects 'primaryKey' to be of type 'Integer'.");
    }

    @Override
    public Zahtjev create() {
        return new Zahtjev();
    }
}
