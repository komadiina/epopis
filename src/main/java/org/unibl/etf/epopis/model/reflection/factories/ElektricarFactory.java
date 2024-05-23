package org.unibl.etf.epopis.model.reflection.factories;

import org.unibl.etf.epopis.model.actors.Elektricar;
import org.unibl.etf.epopis.model.reflection.Factory;
import org.unibl.etf.epopis.model.exceptions.InvalidPrimaryKeyTypeException;

public class ElektricarFactory implements Factory<Elektricar> {
    @Override
    public Elektricar create(Object primaryKey) {
        if (primaryKey instanceof String)
            return new Elektricar((String)primaryKey);
        else throw new InvalidPrimaryKeyTypeException("Elektricar expects 'pk_JMBG' to be of type 'String'.");
    }

    @Override
    public Elektricar create() {
        return new Elektricar();
    }
}
