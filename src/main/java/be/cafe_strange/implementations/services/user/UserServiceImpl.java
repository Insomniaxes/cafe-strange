package be.cafe_strange.implementations.services.user;

import be.cafe_strange.models.user.User;
import be.cafe_strange.interfaces.repositories.UserRepo;
import be.cafe_strange.interfaces.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
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
        Calendar calendar = Calendar.getInstance();
        user.setJoinDate(new java.sql.Date(calendar.getTime().getTime()));
        userRepo.create(user);
        return userRepo.findByUsername(user.getUsername());
    }

    @Override
    public boolean update(User user) {
        user.setPassword(findById(user.getId()).getPassword());
        user.setRoles(findById(user.getId()).getRoles());
        user.setJoinDate(findById(user.getId()).getJoinDate());
        return userRepo.update(user);
    }

    // todo nog confirmatie
    @Override
    public boolean delete(int userId) {
        return userRepo.delete(userId);
    }
}
