package org.unibl.etf.epopis.model.reflection.factories;

import org.unibl.etf.epopis.model.actors.Racun;
import org.unibl.etf.epopis.model.reflection.Factory;
import org.unibl.etf.epopis.model.exceptions.InvalidPrimaryKeyTypeException;

public class RacunFactory implements Factory<Racun> {
    @Override
    public Racun create(Object primaryKey) {
        if (primaryKey instanceof Integer)
            return new Racun((Integer) primaryKey);
        else throw new InvalidPrimaryKeyTypeException("Racun expects 'primaryKey' to be of type 'Integer'.");
    }

    @Override
    public Racun create() {
        return new Racun();
    }
}
