package epopis.model.reflection.specialization;

import epopis.model.actors.Dokument;
import epopis.model.reflection.Factory;
import epopis.model.reflection.InvalidPrimaryKeyType;

public class DokumentFactory implements Factory<Dokument> {
    public Dokument create(Object primaryKey) {
        if (primaryKey instanceof Integer)
            return new Dokument((Integer)primaryKey);
        else throw new InvalidPrimaryKeyType("Dokument expects primary key to be of type 'Integer'");
    }
}
