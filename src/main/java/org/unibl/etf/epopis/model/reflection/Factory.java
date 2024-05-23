package org.unibl.etf.epopis.model.reflection;

import org.unibl.etf.epopis.model.exceptions.InvalidPrimaryKeyTypeException;

public interface Factory<T> {
    T create(Object primaryKey) throws InvalidPrimaryKeyTypeException;
    T create();
}
