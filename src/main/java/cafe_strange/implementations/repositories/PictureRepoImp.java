package cafe_strange.implementations.repositories;

import cafe_strange.interfaces.repositories.PictureRepo;
import cafe_strange.models.media.Picture;
import org.springframework.stereotype.Repository;
import picturing.beans.Picture;
import picturing.repositories.interfaces.PictureRepo;

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
    public Picture findPictureById(int id) {
        return em.find(Picture.class, id);
    }

    @Override
    public List<Picture> findAllPictures() {
        Query query = em.createQuery("SELECT p FROM Picture p");
        return query.getResultList();
    }

    @Override
    public List<Picture> findCategoryPictures(String category) {
        Query query = em.createQuery("SELECT p FROM Picture p WHERE p.pictureCategory LIKE '" + category + "'");
        return query.getResultList();
    }

    @Override
    public List<Picture> findSafePictures() {
        Query query = em.createQuery("SELECT p FROM Picture p WHERE p.safe = true");
        return query.getResultList();
    }

    @Override
    public Picture findPictureByUrl(String url) {
        Query query = em.createQuery("SELECT p FROM Picture p WHERE p.pictureUrl LIKE '" + url + "'");
        if (query.getResultList().size()==0) {
            return new Picture();
            } else {
            return (Picture) query.getSingleResult();
        }
    }
}
