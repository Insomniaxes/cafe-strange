package cafe_strange.implementations.services.user;

import cafe_strange.interfaces.repositories.UserRepo;
import cafe_strange.interfaces.services.UserService;
import cafe_strange.models.user.Role;
import cafe_strange.models.user.User;
import cafe_strange.models.user.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User findById(int id) {
        return userRepo.findById(id);
    }

    @Override
    public UserList findAll() {
        return userRepo.findAll();
    }

    @Override
    public UserList findByLastName(String lastName) {
        return userRepo.findByLastName(lastName);
    }

    @Override
    public UserList findByRole(String role) {
        return userRepo.findByRole(role);
    }

    @Override
    public User create(Object object) {
        return null;
    }

    @Override
    public void update(Object object) {

    }

    // todo nog confirmatie
    @Override
    public void delete(int id) {
        userRepo.delete(id);
    }
}
