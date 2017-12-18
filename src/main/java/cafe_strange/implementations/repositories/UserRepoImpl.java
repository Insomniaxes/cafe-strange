package cafe_strange.implementations.repositories;

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
        return new UserList(query.getResultList());
    }

    @Override
    public User findByUsername(String username) {
        Query query = em.createQuery("SELECT u from User AS u WHERE u.username = '" + username + "'");
        return (User) query.getSingleResult();
    }

    // todo nog uitdokteren
    @Override
    public UserList findByRole(String role) {
        Query query = em.createQuery("SELECT u FROM User AS u WHERE role = " + role );
        return (UserList) query.getResultList();
    }

    @Override
    public User findByEmail(String email) {
        Query query = em.createQuery("SELECT u from User AS u WHERE u.email = '" + email + "'");
        return (User) query.getSingleResult();
    }

    @Override
    public UserList findByLastName(String lastNeme) {
        Query query = em.createQuery("SELECT u from User AS u WHERE u.lastName LIKE '%" + lastNeme + "%'");
        return new UserList(query.getResultList());
    }

    @Override
    public User create(User user) {
        em.persist(user);
        return null;
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public void delete(int id) {
        em.remove(findById(id));
    }

}
