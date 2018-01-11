package be.cafe_strange.implementations.services.media;

import be.cafe_strange.interfaces.services.media.VideoService;
import be.cafe_strange.models.media.Video;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static be.cafe_strange.enums.MediaType.VIDEO;

@Service
@Transactional
public class VideoServiceImpl extends MediaServiceImpl<Video, List<Video>> implements VideoService {

    @Override
    public List<Video> findAll() {
        return super.findAll(VIDEO);
    }

}
