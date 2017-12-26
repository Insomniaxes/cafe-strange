package cafe_strange.interfaces.services.media;

import cafe_strange.interfaces.main.MainInterface;
import cafe_strange.models.media.Media;
import cafe_strange.models.media.Picture;
import cafe_strange.models.media.Video;

import java.util.List;

public interface MediaService extends MainInterface<Media, List<Media>> {

    List<Picture> findAllPictures();
    List<Video> findAllVideos();

}
