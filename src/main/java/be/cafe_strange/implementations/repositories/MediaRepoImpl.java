package be.cafe_strange.implementations.repositories;

import be.cafe_strange.enums.MediaType;
import be.cafe_strange.interfaces.repositories.MediaRepo;
import be.cafe_strange.models.Category;
import be.cafe_strange.models.media.Media;
import be.cafe_strange.models.media.Picture;
import be.cafe_strange.models.media.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MediaRepoImpl<T,L> implements MediaRepo<T,L> {

    @Autowired
    private EntityManager em;

    @Override
    public T findById(int id) {
        return (T) em.find(Media.class, id);
    }

    @Override
    public L findAll() {
        Query query = em.createQuery("SELECT m FROM Media AS m");
        return (L) query.getResultList();
    }

    @Override
    public T findByUrl(String url) {
        Query query = em.createQuery("SELECT m FROM Media AS m WHERE m.url = :url");
        query.setParameter("url", url);
        if (query.getSingleResult() == null) {
            return (T) new Media();
        } else {
            return (T) query.getSingleResult();
        }
    }

    @Override
    public L findByCategory(Category category) {
        Query query = em.createQuery("SELECT m FROM Media AS m WHERE m.category = :category");
        query.setParameter("category", category);
        return (L) query.getResultList();
    }

    @Override
    public L findAllByMediaType(MediaType mediaType) {
        Query query = em.createQuery("SELECT m FROM Media AS m WHERE m.mediaType = :mediaType");
        query.setParameter("mediaType", mediaType);
        return (L) query.getResultList();
    }

    @Override
    public T create(T media) {
        em.persist(media);
        return media;
    }

    @Override
    public boolean update(T media) {
        try {
            em.merge(media);
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
