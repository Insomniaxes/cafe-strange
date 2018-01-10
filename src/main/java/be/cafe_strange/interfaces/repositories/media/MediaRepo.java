package be.cafe_strange.interfaces.repositories.media;

import be.cafe_strange.enums.MediaType;
import be.cafe_strange.interfaces.main.MainInterface;
import be.cafe_strange.models.extra.Category;

public interface MediaRepo<T,L> extends MainInterface<T,L> {

    L findAllByMediaType(MediaType mediaType);
    T findByUrl(String url);

    L findByNewsId(int id, MediaType mediaType);

    L findByCategory(MediaType mediaType, Category category);
    L findByNewsId(int id);

}
