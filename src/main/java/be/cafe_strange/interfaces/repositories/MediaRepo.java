package be.cafe_strange.interfaces.repositories;

import be.cafe_strange.enums.MediaType;
import be.cafe_strange.interfaces.MainInterface;
import be.cafe_strange.models.Category;

public interface MediaRepo<T,L> extends MainInterface<T,L> {

    L findAllByMediaType(MediaType mediaType);
    T findByUrl(String url);

    L findByNewsId(int id, MediaType mediaType);

    L findByCategory(Category category);
    L findByNewsId(int id);

}
