package cafe_strange.interfaces.services;

import cafe_strange.interfaces.main.MainInterface;
import cafe_strange.models.user.User;

import java.util.List;

public interface UserService extends MainInterface<User, List<User>> {

    List<User> findByLastName(String lastName);
    User findByUsername(String username);
    List<User> findByRole(String role);

}
