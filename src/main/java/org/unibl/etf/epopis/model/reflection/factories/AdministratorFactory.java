package org.unibl.etf.epopis.model.reflection.factories;

import org.unibl.etf.epopis.model.actors.Administrator;
import org.unibl.etf.epopis.model.reflection.Factory;
import org.unibl.etf.epopis.model.exceptions.InvalidPrimaryKeyTypeException;

public class AdministratorFactory implements Factory<Administrator> {
    @Override
    public Administrator create(Object primaryKey) {
        if (primaryKey instanceof String)
            return new Administrator((String)primaryKey);
        else throw new InvalidPrimaryKeyTypeException("Zahtjev expects 'primaryKey' to be of type 'String'.");
    }

    @Override
    public Administrator create() {
        return new Administrator();
    }
}
