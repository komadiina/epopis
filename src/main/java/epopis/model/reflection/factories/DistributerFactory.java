package epopis.model.reflection.factories;

import epopis.model.actors.Distributer;
import epopis.model.reflection.Factory;
import epopis.model.reflection.exceptions.InvalidPrimaryKeyTypeException;

public class DistributerFactory implements Factory<Distributer> {
    @Override
    public Distributer create(Object primaryKey) {
        if (primaryKey instanceof Integer)
            return new Distributer((Integer)primaryKey);
        else throw new InvalidPrimaryKeyTypeException("Distributer expects primary key to be of type 'Integer'");
    }

    @Override
    public Distributer create() {
        return new Distributer();
    }
}
