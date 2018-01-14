package be.cafe_strange.implementations.repositories.user;

import be.cafe_strange.interfaces.repositories.RoleRepo;
import be.cafe_strange.models.user.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RoleRepoImpl implements RoleRepo {

    @Autowired
    private EntityManager em;

    @Override
    public Role findById(int id) {
        return em.find(Role.class, id);
    }

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public Role create(Role role) {
        return null;
    }

    @Override
    public boolean update(Role role) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
