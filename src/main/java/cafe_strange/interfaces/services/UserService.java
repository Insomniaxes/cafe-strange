package cafe_strange.interfaces.services;

import cafe_strange.models.user.User;

import java.util.List;

public interface UserService {

    User findById(int id);
    List<User> findAll();
    List<User> findByLastName(String lastName);
    List<User> findByRole(String role);
    User create(User user);
    void update(User user);
    void delete(int userId);

}
