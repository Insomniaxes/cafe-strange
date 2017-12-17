package cafe_strange.controllers;

import cafe_strange.interfaces.services.EventService;
import cafe_strange.interfaces.services.GeneralInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private EventService eventService;
    @Autowired
    private GeneralInfoService infoService;

    @RequestMapping({"/", "/index", "/home"})
    public String getIndex(Model model) {
        model.addAttribute("events", eventService.findUpcomingEvents());
        model.addAttribute("event", eventService.findNextEvent());
        model.addAttribute("info", infoService.findGeneralInfo());
        return "views/index";
    }

}
