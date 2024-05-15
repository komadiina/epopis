package epopis.model.reflection.specialization;

import epopis.model.actors.Distributer;
import epopis.model.reflection.Factory;
import epopis.model.reflection.InvalidPrimaryKeyType;

public class DistributerFactory implements Factory<Distributer> {
    @Override
    public Distributer create(Object primaryKey) {
        if (primaryKey instanceof Integer)
            return new Distributer((Integer)primaryKey);
        else throw new InvalidPrimaryKeyType("Distributer expects primary key to be of type 'Integer'");
    }
}
