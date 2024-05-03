package epopis.model.util;

import lombok.*;

import java.util.List;
import java.util.function.Function;

@NoArgsConstructor
public class SQLDriver<T> implements DAO<T> {
    @Override
    public List<T> getAll() {
        return List.of();
    }

    @Override
    public T read(Object id, Function<Object, T> constructor) {
        StatementEngine<T> se = new StatementEngine<>();
        T instance = constructor.apply(id);
        String SQL_QUERY = se.generateSelect(instance);

        System.out.println(SQL_QUERY);
        return null;
    }

    @Override
    public int create(T m) {
        StatementEngine<T> se = new StatementEngine<>();
        String SQL_QUERY = se.generateInsert(m);

        System.out.println(SQL_QUERY);
        return 0;
    }

    @Override
    public int update(T m, Object id) {
        StatementEngine<T> se = new StatementEngine<>();
        String SQL_QUERY = se.generateUpdate(m, id); // update m primary key with id's value

        System.out.println(SQL_QUERY);
        return 0;
    }

    @Override
    public int delete(Object id, Function<Object, T> constructor) {
        StatementEngine<T> se = new StatementEngine<>();
        T instance = constructor.apply(id);
        String SQL_QUERY = se.generateDelete(instance);

        System.out.println(SQL_QUERY);
        return 0;
    }
}
