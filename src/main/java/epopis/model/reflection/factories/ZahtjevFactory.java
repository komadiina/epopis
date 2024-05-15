package epopis.model.reflection.factories;

import epopis.model.actors.Zahtjev;
import epopis.model.reflection.Factory;
import epopis.model.reflection.exceptions.InvalidPrimaryKeyTypeException;

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
