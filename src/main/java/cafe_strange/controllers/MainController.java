package cafe_strange.controllers;

import cafe_strange.interfaces.services.EventService;
import cafe_strange.interfaces.services.GeneralInfoService;
import cafe_strange.interfaces.services.OpeningHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
    public String getIndex(Model model, ModelMap modelMap, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("openingHours", openingHoursService.findOpeningHours());
        model.addAttribute("upcomingEvents", eventService.findUpcomingEvents());
        model.addAttribute("event", eventService.findNextEvent());
        model.addAttribute("info", infoService.findGeneralInfo());
        return "/index";
    }

}
