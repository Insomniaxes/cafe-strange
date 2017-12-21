package cafe_strange.interfaces.services;

import cafe_strange.models.media.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PictureService {

    Picture findPictureById(int id);
    Picture findPictureByUrl(String url);
    List<Picture> findMainPagePictures(boolean loggedin, String category);
    List<Picture> findAllPictures();
    List<Picture> findCategoryPictures(String category);
    List<Picture> findSafePictures();
    Picture uploadPicture(MultipartFile file, Picture picture);
    void deletePicture(Picture picture);

}
