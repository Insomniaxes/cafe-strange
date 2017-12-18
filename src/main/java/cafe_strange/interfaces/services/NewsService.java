package cafe_strange.interfaces.services;

import cafe_strange.models.event.News;

import java.util.List;

public interface NewsService {

    News findById(int id);
    List<News> findAllNews();
    void create(News news);
    void update(News news);
    void delete(int id);

}
