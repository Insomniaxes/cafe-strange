package cafe_strange.interfaces.repositories;

import cafe_strange.models.event.News;

import java.util.List;

public interface NewsRepo {

    News findById(int id);
    List<News> findAllNews();
    void create(News news);
    void update(News news);
    void delete(int id);

}
