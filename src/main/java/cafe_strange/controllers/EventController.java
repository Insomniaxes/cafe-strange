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

    @Autowired
    private EventService eventService;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String getEventsPage(Model model) {
        model.addAttribute("upcomingEvents", eventService.findUpcoming());
        return "/events/UpcomingEventOverview";
    }

    @RequestMapping(value = "/pastEvents", method = RequestMethod.GET)
    public String getPastEvents(Model model) {
        model.addAttribute("pastEvents", eventService.findPast());
        return "/events/pastEvents";
    }

    @RequestMapping(value = "/{eventId}", method = RequestMethod.GET)
    public String getEventById(@PathVariable int eventId, Model model) {
        model.addAttribute("event", eventService.findById(eventId));
        return "/events/eventView";
    }

    @RequestMapping(value = "/{eventId}/flyer", method = RequestMethod.GET)
    public String getEventFlyer(@PathVariable int eventId, Model model) {
        model.addAttribute("event", eventService.findById(eventId));
        return "/events/eventFlyerView";
    }

    @RequestMapping(value = "/edit/{eventId}", method = RequestMethod.GET)
    public String editEventById(@PathVariable int eventId, Model model) {

        model.addAttribute("event", eventService.findById(eventId));
        return "/events/eventEditView";
    }

    @RequestMapping(value = "/update/{eventId}", method = RequestMethod.POST)
    public String updateEvent(@PathVariable int eventId,
                              @RequestParam(value = "file", required = false) MultipartFile file, Event event) {
        event.setId(eventId);

        if (file != null) {
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
                               Event event,  ModelMap modelMap) {
        if (file != null) {
            // todo nog file aanmaken
        }
        if (eventService.create(event) == null) {
            modelMap.addAttribute("message",
                    "<h1>Het evenement werd niet toegevoegd omdat er al een event gepland staat op die dag !!</h1>");
            return "/index";
        } else {
            modelMap.addAttribute("message", "<h1>Het evenement werd toegevoegd</h1>");
        }
        return "/index";
    }

    @RequestMapping(value = "/delete/{eventId}", method = RequestMethod.POST)
    public String deleteEvent(@PathVariable int eventId) {
        eventService.delete(eventId);
        return "redirect:/index";
    }

}
