package epopis.model.reflection.specialization;

import epopis.model.actors.Snabdjevac;
import epopis.model.reflection.Factory;
import epopis.model.reflection.InvalidPrimaryKeyType;

public class SnabdjevacFactory implements Factory<Snabdjevac> {
    @Override
    public Snabdjevac create(Object primaryKey) {
        if (primaryKey instanceof Integer)
            return new Snabdjevac((Integer) primaryKey);
        else throw new InvalidPrimaryKeyType("Snabdjevac expects 'primaryKey' to be of type 'Integer'.");
    }
}
