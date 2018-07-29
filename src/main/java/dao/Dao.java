package dao;

public interface Dao<T> {
    T create(T t);
    T update(T t);
    void delete(T t);
    T getById(int id);
}
