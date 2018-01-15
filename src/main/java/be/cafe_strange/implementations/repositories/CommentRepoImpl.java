package be.cafe_strange.implementations.repositories;

import be.cafe_strange.interfaces.repositories.CommentRepo;
import be.cafe_strange.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CommentRepoImpl implements CommentRepo {

    @Autowired
    private EntityManager em;

    @Override
    public Comment findById(int id) {
        return em.find(Comment.class, id);
    }

    @Override
    public List<Comment> findAll() {
        Query query = em.createQuery("SELECT c FROM Comment AS c");
        if (query.getResultList().size() == 0) {
            return new ArrayList<>();
        } else {
            return query.getResultList();
        }
    }

    @Override
    public Comment create(Comment comment) {
        em.persist(comment);
        return comment;
    }

    @Override
    public boolean update(Comment comment) {
        try {
            em.merge(comment);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            em.remove(findById(id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
