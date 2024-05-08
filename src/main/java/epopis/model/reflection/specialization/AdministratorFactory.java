package epopis.model.reflection.specialization;

import epopis.model.actors.Administrator;
import epopis.model.reflection.Factory;
import epopis.model.reflection.InvalidPrimaryKeyType;

public class AdministratorFactory implements Factory<Administrator> {
    @Override
    public Administrator create(Object primaryKey) {
        if (primaryKey instanceof String)
            return new Administrator((String)primaryKey);
        else throw new InvalidPrimaryKeyType("Zahtjev expects 'primaryKey' to be of type 'String'.");
    }
}
