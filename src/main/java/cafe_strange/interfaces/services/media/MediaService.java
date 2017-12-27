package cafe_strange.interfaces.services.media;

import cafe_strange.interfaces.main.MainInterface;
import cafe_strange.models.extra.Category;

public interface MediaService<T,L> extends MainInterface<T,L> {

    L findByCategory(Category category);
    T findByUrl(String url);

}
