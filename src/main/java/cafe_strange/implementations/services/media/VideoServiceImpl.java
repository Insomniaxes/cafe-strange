package cafe_strange.implementations.services.media;

import cafe_strange.enums.MediaType;
import cafe_strange.interfaces.repositories.media.MediaRepo;
import cafe_strange.interfaces.services.media.VideoService;
import cafe_strange.models.extra.Category;
import cafe_strange.models.media.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VideoServiceImpl implements VideoService {

    @Autowired
    private MediaRepo<Video, List<Video>> mediaRepo;

    @Override
    public List<Video> findByCategory(Category category) {
        return mediaRepo.findByCategory(MediaType.VIDEO, category);
    }

    @Override
    public Video findByUrl(String url) {
        return mediaRepo.findByUrl(url);
    }

    @Override
    public Video findById(int id) {
        return findById(id);
    }

    @Override
    public List<Video> findAll() {
        return mediaRepo.findByMediaType(MediaType.VIDEO);
    }

    @Override
    public Video create(Video video) {
        return mediaRepo.create(video);
    }

    @Override
    public boolean update(Video video) {
        return mediaRepo.update(video);
    }

    @Override
    public boolean delete(int id) {
        return mediaRepo.delete(id);
    }
}
