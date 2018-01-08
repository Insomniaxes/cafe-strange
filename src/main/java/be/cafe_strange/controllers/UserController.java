package be.cafe_strange.controllers;

import be.cafe_strange.models.user.User;
import be.cafe_strange.interfaces.services.user.UserService;
import be.cafe_strange.models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
@PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
public class UserController {

    private final String FOLDER = "WEB-INF/components/users";
    private final String VIEW = "/users";

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        model.addAttribute("page", FOLDER + "/users");
        model.addAttribute("users", userService.findAll());
        return VIEW;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String getUserById(@PathVariable int userId, Model model) {
        model.addAttribute("page", FOLDER + "/userDetails");
        model.addAttribute(userService.findById(userId));
        return VIEW;
    }

    @RequestMapping(value = "/lastname/{lastName}", method = RequestMethod.GET)
    public String getUsersByLastName(@PathVariable String lastName, Model model) {
        model.addAttribute("page", FOLDER + "/users");
        model.addAttribute("users", userService.findByLastName(lastName));
        return VIEW;
    }

    @RequestMapping(value = "/role/{role}", method = RequestMethod.GET)
    public String getUsersByRole(@PathVariable String role, Model model) {
        model.addAttribute("page", FOLDER + "/users");
        model.addAttribute("users", userService.findByRole(role));
        return VIEW;
    }



    @RequestMapping(value = "/create/", method = RequestMethod.POST)
    public String createUser(User user, Model model) {
        model.addAttribute("page", FOLDER + "/userForm");
        model.addAttribute("user", userService.create(user));
        return VIEW;
    }

    @RequestMapping(value = "/update/{userId}", method = RequestMethod.POST)
    public String updateUser(@PathVariable int userId, Model model, User user) {
        user.setId(userId);
        userService.update(user);
        model.addAttribute("user", user);
        return VIEW;
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable int userId) {
        userService.delete(userId);
        return "/index";
    }

}
