package cafe_strange.implementations.repositories;

import cafe_strange.interfaces.repositories.PictureRepo;
import cafe_strange.models.media.Picture;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PictureRepoImp implements PictureRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Picture findById(int id) {
        return em.find(Picture.class, id);
    }

    @Override
    public List<Picture> findAll() {
        Query query = em.createQuery("SELECT p FROM Picture p");
        return query.getResultList();
    }

    @Override
    public List<Picture> findByCategory(String category) {
        Query query = em.createQuery("SELECT p FROM Picture p WHERE p.pictureCategory LIKE '" + category + "'");
        return query.getResultList();
    }

    @Override
    public List<Picture> findSafePictures() {
        Query query = em.createQuery("SELECT p FROM Picture p WHERE p.safe = true");
        return query.getResultList();
    }

    @Override
    public Picture findByUrl(String url) {
        Query query = em.createQuery("SELECT p FROM Picture p WHERE p.pictureURL LIKE '" + url + "'");
        try {
            return (Picture) query.getSingleResult();
        } catch (Exception e) {
            return new Picture();
        }

    }
}
