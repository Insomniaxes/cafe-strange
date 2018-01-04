package be.cafe_strange.interfaces.services.media;

import be.cafe_strange.models.extra.Category;
import be.cafe_strange.interfaces.main.MainInterface;
import be.cafe_strange.models.extra.Category;

public interface MediaService<T,L> extends MainInterface<T,L> {

    L findByCategory(Category category);
    T findByUrl(String url);

}
