package epopis.model.util;

import epopis.model.reflection.Factory;
import java.util.List;

// T implements Parser<T>
// T obj -> obj.parse(ResultSet rs)
// return T;

public class SQLDriver<T> implements DAO<T> {
    private final Factory<T> factory;

    public SQLDriver(Factory<T> factory) {
        this.factory = factory;
    }

    @Override
    public List<T> getAll() {
        return List.of();
    }

    @Override
    public T read(Object id) {
        StatementEngine<T> se = new StatementEngine<>();
        T instance = factory.create(id);
        String SQL_QUERY = se.generateSelect(instance);

        // TODO
        System.out.println(SQL_QUERY);

        return null;
    }

    @Override
    public int create(T m) {
        StatementEngine<T> se = new StatementEngine<>();
        String SQL_QUERY = se.generateInsert(m);

        // TODO
        System.out.println(SQL_QUERY);

        return 0;
    }

    @Override
    public int update(T m, Object id) {
        StatementEngine<T> se = new StatementEngine<>();
        String SQL_QUERY = se.generateUpdate(m, id); // update m primary key with id's value

        // TODO
        System.out.println(SQL_QUERY);

        return 0;
    }

    @Override
    public int delete(Object id) {
        StatementEngine<T> se = new StatementEngine<>();
        T instance = factory.create(id);
        String SQL_QUERY = se.generateDelete(instance);

        // TODO
        System.out.println(SQL_QUERY);


        return 0;
    }
}
