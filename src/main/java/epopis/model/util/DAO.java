package epopis.model.util;

import java.util.List;

public interface DAO<T> {
    List<T> getAll();
    int create(T m);

    T read(Object id);

    // id can be null, StatementEngine performs null-checks
    int update(T m, Object id);
    int delete(Object id);
}
