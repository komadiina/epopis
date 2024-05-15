package epopis.model.reflection.factories;

import epopis.model.actors.Administrator;
import epopis.model.reflection.Factory;
import epopis.model.reflection.exceptions.InvalidPrimaryKeyTypeException;

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
