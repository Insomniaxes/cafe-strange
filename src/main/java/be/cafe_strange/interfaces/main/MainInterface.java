package be.cafe_strange.interfaces.main;

public interface MainInterface<T, L> {

    T findById(int id);
    L findAll();
    T create(T object);
    boolean update(T object);
    boolean delete(int id);

}
