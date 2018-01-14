package be.cafe_strange.implementations.services.user;

import be.cafe_strange.interfaces.repositories.RoleRepo;
import be.cafe_strange.interfaces.services.RoleService;
import be.cafe_strange.models.user.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Role findById(int id) {
        return roleRepo.findById(id);
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
