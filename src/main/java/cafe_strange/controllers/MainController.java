package cafe_strange.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping({"/", "/index", "/home"})
    private String getIndex(Model model) {
        return "views/index";
    }

}
