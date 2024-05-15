package epopis.model.reflection;

import epopis.model.reflection.exceptions.InvalidPrimaryKeyTypeException;

public interface Factory<T> {
    T create(Object primaryKey) throws InvalidPrimaryKeyTypeException;
    T create();
}
