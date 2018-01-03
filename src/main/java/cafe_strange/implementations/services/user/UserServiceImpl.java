package cafe_strange.implementations.services.user;

import cafe_strange.interfaces.repositories.UserRepo;
import cafe_strange.interfaces.services.user.UserService;
import cafe_strange.models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public List<User> findByLastName(String lastName) {
        return userRepo.findByLastName(lastName);
    }

    @Override
    public List<User> findByRole(String role) {
        return userRepo.findByRole(role);
    }

    @Override
    public User create(User user) {
        userRepo.create(user);
        return userRepo.findByUsername(user.getUsername());
    }

    @Override
    public boolean update(User user) {
        return userRepo.update(user);
    }

    // todo nog confirmatie
    @Override
    public boolean delete(int userId) {
        return userRepo.delete(userId);
    }
}