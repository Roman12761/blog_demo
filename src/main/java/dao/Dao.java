package dao;

public interface Dao<T> {
    int create(T t);
    void update(T t);
    void delete(T t);
    T getById(Class<T> tClass, int id);
}
