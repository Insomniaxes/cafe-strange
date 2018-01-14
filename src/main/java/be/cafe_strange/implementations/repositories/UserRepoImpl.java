package be.cafe_strange.implementations.repositories;

import be.cafe_strange.models.user.User;
import be.cafe_strange.interfaces.repositories.UserRepo;
import be.cafe_strange.models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserRepoImpl implements UserRepo {

    @Autowired
    private EntityManager em;

    @Override
    public User findById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        Query query = em.createQuery("SELECT u from User AS u");
        return (List<User>) (query.getResultList());
    }

    @Override
    public User findByUsername(String username) {
        Query query = em.createQuery("SELECT u from User AS u WHERE u.username = :username");
        query.setParameter("username", username);
        try {
            User user = (User) query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<User> findByRole(String role) {
        Query query = em.createQuery("SELECT u FROM User AS u WHERE u.role = " + role );
        return (List<User>) query.getResultList();
    }

    @Override
    public User findByEmail(String email) {
        Query query = em.createQuery("SELECT u from User AS u WHERE u.email = '" + email + "'");
        try {
            User user = (User) query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<User> findByLastName(String lastNeme) {
        Query query = em.createQuery("SELECT u from User AS u WHERE u.lastName LIKE '%" + lastNeme + "%'");
        return (List<User>) (query.getResultList());
    }

    @Override
    public User create(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public boolean update(User user) {
        try {
            em.merge(user);
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
