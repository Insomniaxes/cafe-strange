package be.cafe_strange.implementations.services;

import be.cafe_strange.interfaces.services.media.PictureService;
import be.cafe_strange.interfaces.services.media.VideoService;
import be.cafe_strange.models.News;
import be.cafe_strange.interfaces.repositories.NewsRepo;
import be.cafe_strange.interfaces.services.NewsService;
import be.cafe_strange.models.media.Media;
import be.cafe_strange.models.media.Picture;
import be.cafe_strange.models.media.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepo repo;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private VideoService videoService;

    @Override
    public News findById(int id) {
        List<Media> newsMedia = new ArrayList<>();
        for (Picture picture : pictureService.findByNewsId(id)) {
            System.out.println(picture.getId());
            newsMedia.add(picture);
        }
        for (Video video : videoService.findByNewsId(id)) {
            System.out.println(video.getId());
            newsMedia.add(video);
        }
        News news = repo.findById(id);
        news.setMedia(newsMedia);
        return news;
    }

    @Override
    public List<News> findAll() {
        return repo.findAll();
    }

    @Override
    public News create(News news) {
        repo.create(news);
        return news;
    }

    @Override
    public boolean update(News news) {
        return repo.update(news);
    }

    @Override
    public boolean delete(int id) {
        return repo.delete(id);
    }

}
