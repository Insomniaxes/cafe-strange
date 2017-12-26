package cafe_strange.interfaces.services.media;

import cafe_strange.interfaces.main.MediaInterface;
import cafe_strange.models.extra.Category;
import cafe_strange.models.media.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PictureService extends MediaInterface<Picture, List<Picture>> {

    Picture uploadPicture(MultipartFile file, String folder, Category category);

}
