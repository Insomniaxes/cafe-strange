package be.cafe_strange.interfaces.services;

import be.cafe_strange.models.user.User;
import be.cafe_strange.interfaces.MainInterface;

import java.util.List;

public interface UserService extends MainInterface<User, List<User>> {

    User findByEmail(String email);

    List<User> findByLastName(String lastName);

    User findByUsername(String username);

    List<User> findByRole(String role);

    String checkUserCreateFormData(User user, String passwordRetype);
}
