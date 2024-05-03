package epopis.model.util;

import java.util.List;
import java.util.function.Function;

public interface DAO<T> {
    List<T> getAll();
    int create(T m);
    T read(Object id, Function<Object, T> constructor);
    int update(T m, Object id);
    int delete(Object id, Function<Object, T> constructor);
}
