package cafe_strange.implementations.repositories.user;

import cafe_strange.interfaces.repositories.UserRepo;
import cafe_strange.models.user.User;
import cafe_strange.models.user.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

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
    public UserList findAll() {
        Query query = em.createQuery("SELECT u from User AS u");
        return (UserList) query.getResultList();
    }

    @Override
    public User findByUsername(String username) {
        Query query = em.createQuery("SELECT u from User AS u WHERE u.username = '" + username + "'");
        return (User) query.getSingleResult();
    }

    @Override
    public User findByEmail(String email) {
        Query query = em.createQuery("SELECT u from User AS u WHERE u.email = '" + email + "'");
        return (User) query.getSingleResult();
    }

    @Override
    public UserList findByLastName(String lastNeme) {
        Query query = em.createQuery("SELECT u from User AS u WHERE u.lastName LIKE '%" + lastNeme + "%'");
        return (UserList) query.getResultList();
    }

    @Override
    public User create(Object object) {
        em.persist(object);
        return null;
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
