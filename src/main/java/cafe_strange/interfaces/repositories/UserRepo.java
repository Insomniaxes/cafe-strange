package cafe_strange.interfaces.repositories;

import cafe_strange.interfaces.main.MainInterface;
import cafe_strange.models.user.User;

import java.util.List;

public interface UserRepo extends MainInterface<User, List<User>> {

    User findByUsername(String username);

    User findByEmail(String email);

    List<User>findByLastName(String lastNeme);

    List<User> findByRole(String role);

}
