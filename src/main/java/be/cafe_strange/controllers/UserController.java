package be.cafe_strange.controllers;

import be.cafe_strange.enums.Gender;
import be.cafe_strange.models.user.User;
import be.cafe_strange.interfaces.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequestMapping("/users")
@PreAuthorize("hasAnyRole('MEMBER', 'ADMIN', 'MASTER')")
public class UserController {

    private final String FOLDER = "WEB-INF/components/users";
    private final String VIEW = "/users";
    private String pageTitle;

    @Autowired
    private UserService userService;

    @ModelAttribute("pageTitle")
    public String getPageTitle() {
        pageTitle = "Gebruikers";
        return pageTitle;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MASTER')")
    @RequestMapping(method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        model.addAttribute("page", FOLDER + "/users");
        model.addAttribute("users", userService.findAll());
        return VIEW;
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String getUserById(@PathVariable int userId, Model model, HttpServletRequest request) {
        User user = userService.findById(userId);
        if (user.getUsername().equals(request.getUserPrincipal().getName()) | request.isUserInRole("MASTER") | request.isUserInRole("ADMIN")) {
            model.addAttribute("page", FOLDER + "/userDetails");
            model.addAttribute(user);
        } else {
            return "redirect:/home";
        }

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

    @RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
    public String editUser(@PathVariable int userId, Model model, HttpServletRequest request) {
        User user = userService.findById(userId);
        if (user.getUsername().equals(request.getUserPrincipal().getName()) | request.isUserInRole("MASTER") | request.isUserInRole("ADMIN")) {
            model.addAttribute("genders", Gender.values());
            model.addAttribute("page", FOLDER + "/userForm1");
            model.addAttribute("user", userService.findById(userId));
        } else {
            return "redirect:/home";
        }
        return VIEW;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createUser(User user, Model model) {
        model.addAttribute("page", FOLDER + "/userRegisterForm");
        model.addAttribute("user", userService.create(user));
        return VIEW;
    }

    @RequestMapping(value = "/update/{userId}", method = RequestMethod.POST)
    public String updateUser(@PathVariable int userId, Model model, User user) {
        user.setId(userId);
        userService.update(user);
        model.addAttribute("user", user);
        return "redirect:" + VIEW;
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable int userId) {
        userService.delete(userId);
        return "/index";
    }

}
