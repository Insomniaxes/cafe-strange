package be.cafe_strange.controllers;

import be.cafe_strange.interfaces.services.EventService;
import be.cafe_strange.interfaces.services.general.GeneralInfoService;
import be.cafe_strange.interfaces.services.general.OpeningHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = {"/", "/index", "/home"}, method = RequestMethod.GET)
    public String getIndex(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("openingHours", openingHoursService.findOpeningHours());
        model.addAttribute("pageTitle", "Cafe Strange");
        model.addAttribute("upcomingEvents", eventService.findUpcoming());
        model.addAttribute("event", eventService.findNext());
        model.addAttribute("info", infoService.findIntroInfo());
        return "/index";
    }

}
