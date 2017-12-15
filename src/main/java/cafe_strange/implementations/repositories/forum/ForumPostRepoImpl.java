package cafe_strange.implementations.repositories.forum;

import cafe_strange.interfaces.repositories.ForumPostRepo;
import cafe_strange.models.forum.ForumPost;
import cafe_strange.models.forum.ForumPostList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ForumPostRepoImpl implements ForumPostRepo {

    @Autowired
    private EntityManager em;

    @Override
    public ForumPost findById(int id) {
        return em.find(ForumPost.class, id);
    }

    @Override
    public ForumPostList findAll() {
        Query query = em.createQuery("SELECT f FROM ForumPost AS f");
        return (ForumPostList) query.getResultList();
    }

    @Override
    public ForumPost create(Object object) {
        em.persist(object);
        return (ForumPost) object;
    }

    @Override
    public void update(Object object) {
        em.merge(object);
    }

    @Override
    public void delete(int id) {
        em.remove(findById(id));
    }
}
