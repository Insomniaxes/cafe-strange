package cafe_strange.interfaces.repositories.media;

import cafe_strange.enums.MediaType;
import cafe_strange.interfaces.main.MainInterface;
import cafe_strange.models.media.Media;
import cafe_strange.models.media.Picture;

import java.util.List;

public interface MediaRepo extends MainInterface<Media, List<Media>> {

    List<?> findAllByMediaType(MediaType mediaType);

}
