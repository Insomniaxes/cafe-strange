package cafe_strange.implementations.repositories;

import cafe_strange.interfaces.repositories.ForumPostRepo;
import cafe_strange.models.forum.ForumPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

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
    public List<ForumPost> findAll() {
        Query query = em.createQuery("SELECT f FROM ForumPost AS f");
        return (List<ForumPost>) query.getResultList();
    }

    @Override
    public List<ForumPost> findByUsername(String username) {
        Query query = em.createQuery("SELECT f FROM ForumPost AS f WHERE f.username = " + username);
        return (List<ForumPost>) query.getResultList();
    }

    @Override
    public ForumPost create(ForumPost forumPost) {
        em.persist(forumPost);
        return forumPost;
    }

    @Override
    public boolean update(ForumPost forumPost) {
        try {
            em.merge(forumPost);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int forumPostId) {
        try {
            em.remove(findById(forumPostId));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
