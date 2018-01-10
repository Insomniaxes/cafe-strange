package be.cafe_strange.interfaces.services.media;

import be.cafe_strange.enums.MediaType;
import be.cafe_strange.models.Category;
import be.cafe_strange.interfaces.MainInterface;

public interface MediaService<T, L> extends MainInterface<T, L> {

    L findByCategory(Category category);

    T findByUrl(String url);

    L findByNewsId(int id);

    L findByNewsId(int id, MediaType mediaType);

}
