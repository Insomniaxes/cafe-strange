package cafe_strange.interfaces.services;

import cafe_strange.models.user.Role;
import cafe_strange.models.user.User;
import cafe_strange.models.user.UserList;

import java.util.List;
import java.util.Set;

public interface UserService {

    User findById(int id);
    UserList findAll();
    UserList findByLastName(String lastName);
    UserList findByRole(String role);
    User create(User user);
    void update(User user, List<Role> roles);
    void delete(int userId);

}
