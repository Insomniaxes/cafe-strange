package cafe_strange.interfaces.services;

import cafe_strange.interfaces.main.MainInterface;
import cafe_strange.interfaces.main.MediaInterface;
import cafe_strange.models.extra.Category;
import cafe_strange.models.media.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PictureService extends MediaInterface<Picture, List<Picture>> {

    Picture findByUrl(String url);
    List<Picture> findSafePictures();
    Picture uploadPicture(MultipartFile file, Picture picture, String folder);
    void deletePicture(Picture picture);

}
