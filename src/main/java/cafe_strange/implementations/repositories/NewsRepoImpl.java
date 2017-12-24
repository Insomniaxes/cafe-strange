package cafe_strange.implementations.repositories;

import cafe_strange.interfaces.repositories.NewsRepo;
import cafe_strange.models.event.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class NewsRepoImpl implements NewsRepo {

    @Autowired
    private EntityManager em;

    @Override
    public News findById(int id) {
        return em.find(News.class, id);
    }

    @Override
    public List<News> findAll() {
        Query query = em.createQuery("SELECT n FROM News AS n");
        return (List<News>) query.getResultList();
    }

    @Override
    public void create(News news) {
        em.persist(news);
    }

    @Override
    public void update(News news) {
        em.merge(news);
    }

    @Override
    public void delete(int id) {
        em.remove(findById(id));
    }

}
