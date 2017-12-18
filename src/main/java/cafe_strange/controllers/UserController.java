package cafe_strange.controllers;

import cafe_strange.enums.Gender;
import cafe_strange.interfaces.services.UserService;
import cafe_strange.enums.Role;
import cafe_strange.models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "views/user/userOverview";
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String getUserById(@PathVariable int userId, Model model) {
        model.addAttribute(userService.findById(userId));
        return "views/user/userDetails";
    }

    @RequestMapping(value = "/lastname/{lastName}", method = RequestMethod.GET)
    public String getUsersByLastName(@PathVariable String lastName, Model model) {
        model.addAttribute("users", userService.findByLastName(lastName));
        return "views/user/userOverview";
    }

    @RequestMapping(value = "/role/{role}", method = RequestMethod.GET)
    public String getUsersByRole(@PathVariable String role, Model model) {
        model.addAttribute("users", userService.findByRole(role));
        return "components/user/userList";
    }

    @RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
    public String editUser(@PathVariable int userId, Model model) {
        List<Gender> genders = new ArrayList<>(Arrays.asList(Gender.values()));
        model.addAttribute("genderList", genders);
        List<Role> roles = new ArrayList<>(Arrays.asList(Role.values()));
        model.addAttribute("roleList", roles);
        model.addAttribute("user", userService.findById(userId));
        return "views/user/userDetailsEdit";
    }

    @RequestMapping(value = "/createNew", method = RequestMethod.GET)
    public String getCreateUserForm(Model model) {
        List<Gender> genders = new ArrayList<>(Arrays.asList(Gender.values()));
        model.addAttribute("genderList", genders);
        List<Role> roles = new ArrayList<>(Arrays.asList(Role.values()));
        model.addAttribute("roleList", roles);
        return "views/user/userDetailsEdit";
    }

    @RequestMapping(value = "/create/", method = RequestMethod.POST)
    public String createUser(User user, Model model) {
        model.addAttribute("user", userService.create(user));
        return "views/user/userDetails";
    }

    @RequestMapping(value = "/update/{userId}")
    public String updateUser(@PathVariable int userId, Model model, User user) {
        user.setId(userId);
        userService.update(user);
        model.addAttribute("user", user);
        return "views/user/userDetails";
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable int userId) {
        userService.delete(userId);
        return "index";
    }

}
