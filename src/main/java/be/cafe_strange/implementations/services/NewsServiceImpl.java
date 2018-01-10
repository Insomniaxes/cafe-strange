package be.cafe_strange.implementations.services;

import be.cafe_strange.interfaces.repositories.NewsRepo;
import be.cafe_strange.interfaces.services.NewsService;
import be.cafe_strange.models.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepo repo;

    @Override
    public News findById(int id) {
        return repo.findById(id);
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
