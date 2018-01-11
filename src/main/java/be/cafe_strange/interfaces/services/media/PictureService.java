package be.cafe_strange.interfaces.services.media;

import be.cafe_strange.models.Category;
import be.cafe_strange.models.media.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PictureService extends MediaService<Picture, List<Picture>> {

    Picture uploadPicture(MultipartFile file, String folder, Category category);

    boolean delete(Picture picture);
}
