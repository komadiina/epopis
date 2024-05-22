package org.unibl.etf.epopis.model.reflection.factories;

import org.unibl.etf.epopis.model.actors.Dokument;
import org.unibl.etf.epopis.model.reflection.Factory;
import org.unibl.etf.epopis.model.reflection.exceptions.InvalidPrimaryKeyTypeException;

public class DokumentFactory implements Factory<Dokument> {
    public Dokument create(Object primaryKey) {
        if (primaryKey instanceof Integer)
            return new Dokument((Integer)primaryKey);
        else throw new InvalidPrimaryKeyTypeException("Dokument expects primary key to be of type 'Integer'");
    }

    @Override
    public Dokument create() {
        return new Dokument();
    }
}
