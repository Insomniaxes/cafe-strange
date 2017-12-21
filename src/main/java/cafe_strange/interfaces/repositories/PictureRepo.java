package cafe_strange.interfaces.repositories;

import cafe_strange.models.media.Picture;

import java.util.List;

public interface PictureRepo {

    Picture findPictureById(int id);
    List<Picture> findAllPictures();
    List<Picture> findCategoryPictures(String category);
    List<Picture> findSafePictures();
    Picture findPictureByUrl(String url);

}
