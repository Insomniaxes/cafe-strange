package cafe_strange.implementations.repositories.media;

import cafe_strange.interfaces.repositories.media.MediaRepo;
import cafe_strange.models.media.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MediaRepoImpl implements MediaRepo {

    @Autowired
    private EntityManager em;

    @Override
    public Media findById(int id) {
        return em.find(Media.class, id);
    }

    @Override
    public List<Media> findAll() {
        Query query = em.createQuery("SELECT m FROM Media AS m");
        return query.getResultList();
    }

    @Override
    public Media create(Media media) {
        em.persist(media);
        return media;
    }

    @Override
    public boolean update(Media media) {
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
