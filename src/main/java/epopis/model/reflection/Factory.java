package epopis.model.reflection;

public interface Factory<T> {
    T create(Object primaryKey) throws InvalidPrimaryKeyType;
}
