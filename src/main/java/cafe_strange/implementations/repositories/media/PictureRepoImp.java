package cafe_strange.implementations.repositories.media;

import cafe_strange.interfaces.repositories.media.PictureRepo;
import cafe_strange.models.extra.Category;
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
    public List<Picture> findByCategory(Category category) {
        Query query = em.createQuery("SELECT p FROM Picture p WHERE p.pictureCategory LIKE '" + category + "'");
        return query.getResultList();
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Picture findByUrl(String url) {
        Query query = em.createQuery("SELECT p FROM Media AS p WHERE p.url LIKE '" + url + "'");
        try {
            return (Picture) query.getSingleResult();
        } catch (Exception e) {
            return new Picture();
        }
    }

    @Override
    public Picture create(Picture picture) {
        em.persist(picture);
        return picture;
    }

    @Override
    public boolean update(Picture picture) {
        try {
            em.merge(picture);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
