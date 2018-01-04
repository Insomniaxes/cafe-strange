package be.cafe_strange.implementations.services.media;

import be.cafe_strange.enums.MediaType;
import be.cafe_strange.interfaces.repositories.media.VideoRepo;
import be.cafe_strange.models.extra.Category;
import be.cafe_strange.models.media.Video;
import be.cafe_strange.enums.MediaType;
import be.cafe_strange.interfaces.repositories.media.VideoRepo;
import be.cafe_strange.interfaces.services.media.VideoService;
import be.cafe_strange.models.extra.Category;
import be.cafe_strange.models.media.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepo videoRepo;

    @Override
    public List<Video> findByCategory(Category category) {
        return videoRepo.findByCategory(MediaType.VIDEO, category);
    }

    @Override
    public Video findByUrl(String url) {
        return videoRepo.findByUrl(url);
    }

    @Override
    public Video findById(int id) {
        return findById(id);
    }

    @Override
    public List<Video> findAll() {
        return videoRepo.findByMediaType(MediaType.VIDEO);
    }

    @Override
    public Video create(Video video) {
        return videoRepo.create(video);
    }

    @Override
    public boolean update(Video video) {
        return videoRepo.update(video);
    }

    @Override
    public boolean delete(int id) {
        return videoRepo.delete(id);
    }
}
