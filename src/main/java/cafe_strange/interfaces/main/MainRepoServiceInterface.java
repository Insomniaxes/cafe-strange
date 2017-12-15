package cafe_strange.interfaces.main;

public interface MainRepoServiceInterface<T, L> {

    T findById(int id);
    L findAll();
    T create(Object object);
    void update(Object object);
    void delete(int id);

}
