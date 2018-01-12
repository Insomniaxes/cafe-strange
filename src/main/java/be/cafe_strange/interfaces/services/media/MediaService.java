package be.cafe_strange.interfaces.services.media;

import be.cafe_strange.enums.MediaType;
import be.cafe_strange.models.Category;
import be.cafe_strange.interfaces.MainInterface;
import be.cafe_strange.models.media.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MediaService<T, L> extends MainInterface<T, L> {

    L findAll(MediaType mediaType);

    L findByCategory(Category category);

    T findByUrl(String url);

}
