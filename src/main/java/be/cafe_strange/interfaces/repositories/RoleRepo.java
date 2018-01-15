package be.cafe_strange.interfaces.repositories;

import be.cafe_strange.interfaces.MainInterface;
import be.cafe_strange.models.user.Role;

import java.util.List;

public interface RoleRepo extends MainInterface<Role, List<Role>> {

    Role findById(int id);

}
