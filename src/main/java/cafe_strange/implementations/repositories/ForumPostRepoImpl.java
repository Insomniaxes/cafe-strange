package cafe_strange.implementations.repositories;

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
    public ForumPostList findByUsername(String username) {
        Query query = em.createQuery("SELECT f FROM ForumPost AS f WHERE f.username = " + username);
        return (ForumPostList) query.getResultList();
    }

    @Override
    public ForumPost create(ForumPost forumPost) {
        em.persist(forumPost);
        return (ForumPost) forumPost;
    }

    @Override
    public void update(ForumPost forumPost) {
        em.merge(forumPost);
    }

    @Override
    public void delete(int forumPostId) {
        em.remove(findById(forumPostId));
    }


}
