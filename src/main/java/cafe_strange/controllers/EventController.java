package cafe_strange.controllers;

import cafe_strange.interfaces.services.EventService;
import cafe_strange.interfaces.services.extra.CategoryService;
import cafe_strange.interfaces.services.media.PictureService;
import cafe_strange.models.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/events")
public class EventController {

    private final String FOLDER = "components/events/";
    private final String VIEW = "events/eventView";

    @Autowired
    private EventService eventService;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String getEventsPage(Model model) {
        model.addAttribute("page", FOLDER + "upcomingIndex");
        model.addAttribute("upcomingEvents", eventService.findUpcoming());
        return VIEW;
    }

    @RequestMapping(value = "/pastEvents", method = RequestMethod.GET)
    public String getPastEvents(Model model) {
        model.addAttribute("page", FOLDER + "pastEvents");
        model.addAttribute("pastEvents", eventService.findPast());
        return VIEW;
    }

    @RequestMapping(value = "/{eventId}", method = RequestMethod.GET)
    public String getEventById(@PathVariable int eventId, Model model) {
        model.addAttribute("page", FOLDER + "eventView");
        model.addAttribute("event", eventService.findById(eventId));
        return VIEW;
    }

    @RequestMapping(value = "/flyer/{eventId}", method = RequestMethod.GET)
    public String getEventFlyer(@PathVariable int eventId, Model model) {
        model.addAttribute("page", FOLDER + "eventFlyerView");
        model.addAttribute("event", eventService.findById(eventId));
        return VIEW;
    }

    @RequestMapping(value = "/edit/{eventId}", method = RequestMethod.GET)
    public String editEventById(@PathVariable int eventId, Model model) {
        model.addAttribute("page", FOLDER + "eventEditView");
        model.addAttribute("event", eventService.findById(eventId));
        return VIEW;
    }

    @RequestMapping(value = "/update/{eventId}", method = RequestMethod.POST)
    public String updateEvent(@PathVariable int eventId,
                              @RequestParam(value = "file", required = false) MultipartFile file, Event event) {
        event.setId(eventId);
        if (file != null) {
            // todo nog mogelijkheid maken voor category
            event.setPicture(pictureService.uploadPicture(file, "event", categoryService.findById(1)));
        }
        eventService.update(event);
        return "redirect:/index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String createNewEvent() {
        return "/events/eventCreate";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveNewEvent(@RequestParam(value = "file", required = false) MultipartFile file,
                               Event event,  Model model) {

        if (eventService.create(event) == null) {
            model.addAttribute("message",
                    "<h1>Het evenement werd niet toegevoegd omdat er al een event gepland staat op die dag !!</h1>");
            return "/index";
        } else {
            if (file != null) {
                // todo nog mogelijkheid maken voor category
                event.setPicture(pictureService.uploadPicture(file, "event", categoryService.findById(1)));
            }
            model.addAttribute("message", "<h1>Het evenement werd toegevoegd</h1>");
        }
        return "/index";
    }

    @RequestMapping(value = "/delete/{eventId}", method = RequestMethod.POST)
    public String deleteEvent(@PathVariable int eventId) {
        // todo nog check maken of het echt verwijderd mag worden
        eventService.delete(eventId);
        return "redirect:/index";
    }

}
