package cafe_strange.controllers;

import cafe_strange.interfaces.services.EventService;
import cafe_strange.interfaces.services.GeneralInfoService;
import cafe_strange.interfaces.services.OpeningHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    private EventService eventService;
    @Autowired
    private GeneralInfoService infoService;
    @Autowired
    private OpeningHoursService openingHoursService;

    @RequestMapping({"/", "/index", "/home"})
    public String getIndex(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("openingHours", openingHoursService.findOpeningHours());
        model.addAttribute("events", eventService.findUpcomingEvents());
        model.addAttribute("event", eventService.findNextEvent());
        model.addAttribute("info", infoService.findGeneralInfo());
        return "views/index";
    }

}
