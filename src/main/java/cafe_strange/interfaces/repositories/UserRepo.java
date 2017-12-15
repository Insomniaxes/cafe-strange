package cafe_strange.interfaces.repositories;

import cafe_strange.interfaces.main.MainRepoServiceInterface;
import cafe_strange.models.user.User;
import cafe_strange.models.user.UserList;

public interface UserRepo extends MainRepoServiceInterface<User, UserList> {

    User findByUsername(String username);
    User findByEmail(String email);
    UserList findByLastName(String lastNeme);

}
