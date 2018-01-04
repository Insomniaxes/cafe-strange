package be.cafe_strange.implementations.repositories.media;

import be.cafe_strange.enums.MediaType;
import be.cafe_strange.models.extra.Category;
import be.cafe_strange.models.media.Media;
import be.cafe_strange.enums.MediaType;
import be.cafe_strange.interfaces.repositories.media.MediaRepo;
import be.cafe_strange.models.extra.Category;
import be.cafe_strange.models.media.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

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
        return null;
    }

    @Override
    public L findByCategory(MediaType mediaType, Category category) {
        Query query = em.createQuery("SELECT m FROM Media AS m WHERE m.mediaType = :mediaType AND m.category = :category");
        query.setParameter("mediaType", mediaType);
        query.setParameter("category", category);
        return (L) query.getResultList();
    }

    @Override
    public L findByMediaType(MediaType mediaType) {
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
    public boolean update(Object media) {
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
