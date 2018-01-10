package be.cafe_strange.interfaces;

public interface MainInterface<T, L> {

    T findById(int id);
    L findAll();
    T create(T t);
    boolean update(T t);
    boolean delete(int id);

}
