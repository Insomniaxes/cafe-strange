package cafe_strange.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginInForm() {
        return "login/login";
    }

}
