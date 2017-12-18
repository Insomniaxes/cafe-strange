package cafe_strange.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @RequestMapping(method = RequestMethod.GET)
    public String getContactPage() {
        return "views/general/contact";
    }

}
