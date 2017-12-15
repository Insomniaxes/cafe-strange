package cafe_strange.controllers;

import cafe_strange.interfaces.services.UserService;
import cafe_strange.models.user.Role;
import cafe_strange.models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll().getUsers());
        return "components/userList";
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String getUserById(@PathVariable int userId, Model model){
        model.addAttribute(userService.findById(userId));
        return "components/userDetails";
    }

    @RequestMapping(value = "/lastname/{lastName}", method = RequestMethod.GET)
    public String getUsersByLastName(@PathVariable String lastName, Model model) {
        model.addAttribute("users", userService.findByLastName(lastName).getUsers());
        return "components/userList";
    }

    @RequestMapping(value = "/role/{role}", method = RequestMethod.GET)
    public String getUsersByRole(@PathVariable String role, Model model) {
        model.addAttribute("users", userService.findByRole(role).getUsers());
        return "components/userList";
    }

    @RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
    public String editUser(@PathVariable int userId, Model model) {
        model.addAttribute("user", userService.findById(userId));
        return "components/userDetails";
    }

    @RequestMapping(value = "/create/{user}", method = RequestMethod.POST)
    public String createUser(@PathVariable User user, Model model) {
        model.addAttribute("user", userService.create(user));
        return "components/userDetails";
    }

    @RequestMapping(value = "/update/{userId}")
    public String updateUser(@PathVariable int userId, Model model, User user) {
        user.setId(userId);
        userService.update(user);
        model.addAttribute("user", user);
        return "components/userDetails";
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable int userId) {
        userService.delete(userId);
        return "index";
    }

}
