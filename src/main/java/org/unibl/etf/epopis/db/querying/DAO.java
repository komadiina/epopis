package org.unibl.etf.epopis.db.querying;

import java.util.List;

public interface DAO<T> {
    List<T> getAll();
    int create(T m);
    T read(Object id);
    int update(T m, Object id);
    int delete(Object id);
}
