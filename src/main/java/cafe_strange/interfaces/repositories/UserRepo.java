package cafe_strange.interfaces.repositories;

import cafe_strange.models.user.User;

import java.util.List;

public interface UserRepo {

    User findById(int id);

    List<User> findAll();

    User findByUsername(String username);

    User findByEmail(String email);

    List<User>findByLastName(String lastNeme);

    List<User> findByRole(String role);

    User create(User user);

    void update(User user);

    void delete(int userId);
}
