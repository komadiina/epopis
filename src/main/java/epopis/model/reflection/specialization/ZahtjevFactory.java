package epopis.model.reflection.specialization;

import epopis.model.actors.Zahtjev;
import epopis.model.reflection.Factory;
import epopis.model.reflection.InvalidPrimaryKeyType;

public class ZahtjevFactory implements Factory<Zahtjev> {
    @Override
    public Zahtjev create(Object primaryKey) {
        if (primaryKey instanceof Integer)
            return new Zahtjev((Integer) primaryKey);
        else throw new InvalidPrimaryKeyType("Zahtjev expects 'primaryKey' to be of type 'Integer'.");
    }
}
