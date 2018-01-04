package be.cafe_strange.implementations.repositories;

import be.cafe_strange.models.event.News;
import be.cafe_strange.interfaces.repositories.NewsRepo;
import be.cafe_strange.models.event.News;
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
    public News create(News news) {
        em.persist(news);
        return news;
    }

    @Override
    public boolean update(News news) {
        try {
            em.merge(news);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            em.remove(findById(id));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
