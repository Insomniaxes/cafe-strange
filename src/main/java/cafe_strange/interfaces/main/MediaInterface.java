package cafe_strange.interfaces.main;

import cafe_strange.models.extra.Category;

public interface MediaInterface<T,L> extends MainInterface<T, L> {

    T findByUrl(String url);
    L findByCategory(Category category);

}
