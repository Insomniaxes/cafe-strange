package cafe_strange.interfaces.repositories;

import cafe_strange.models.user.User;
import cafe_strange.models.user.UserList;

public interface UserRepo {

    User findById(int id);

    UserList findAll();

    User findByUsername(String username);

    User findByEmail(String email);

    UserList findByLastName(String lastNeme);

    UserList findByRole(String role);

    User create(User user);

    void update(User user);

    void delete(int userId);
}
