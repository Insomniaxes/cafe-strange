package cafe_strange.interfaces.services;

import cafe_strange.interfaces.main.MainRepoServiceInterface;
import cafe_strange.models.user.User;
import cafe_strange.models.user.UserList;

public interface UserService extends MainRepoServiceInterface<User, UserList> {
}
