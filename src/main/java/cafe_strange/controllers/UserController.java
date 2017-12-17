package cafe_strange.controllers;

import cafe_strange.enums.Gender;
import cafe_strange.interfaces.services.UserService;
import cafe_strange.models.user.Role;
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
import java.util.Set;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll().getUsers());
        return "views/userOverview";
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String getUserById(@PathVariable int userId, Model model) {
        model.addAttribute(userService.findById(userId));
        return "views/userDetails";
    }

    @RequestMapping(value = "/lastname/{lastName}", method = RequestMethod.GET)
    public String getUsersByLastName(@PathVariable String lastName, Model model) {
        model.addAttribute("users", userService.findByLastName(lastName).getUsers());
        return "views/userOverview";
    }

    @RequestMapping(value = "/role/{role}", method = RequestMethod.GET)
    public String getUsersByRole(@PathVariable String role, Model model) {
        model.addAttribute("users", userService.findByRole(role).getUsers());
        return "components/user/userList";
    }

    @RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
    public String editUser(@PathVariable int userId, Model model) {
        List<Gender> genders = new ArrayList<Gender>(Arrays.asList(Gender.values()));
        model.addAttribute("genderList", genders);
        model.addAttribute("user", userService.findById(userId));
        return "views/userDetailsEdit";
    }

    @RequestMapping(value = "/create/{user}", method = RequestMethod.POST)
    public String createUser(@PathVariable User user, Model model) {
        model.addAttribute("user", userService.create(user));
        return "components/user/userDetails";
    }

    @RequestMapping(value = "/update/{userId}")
    public String updateUser(@PathVariable int userId, Model model, User user, ArrayList<Role> roles) {
        user.setId(userId);
        userService.update(user, roles);
        model.addAttribute("user", user);
        return "views/userDetails";
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable int userId) {
        userService.delete(userId);
        return "index";
    }

}
