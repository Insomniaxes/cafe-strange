package cafe_strange.controllers;

import cafe_strange.interfaces.services.EventService;
import cafe_strange.models.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.GET)
    public String getEventsPage(Model model) {
        model.addAttribute("upcomingEvents", eventService.findUpcomingEvents());
        return "/events/UpcomingEventOverview";
    }

    @RequestMapping(value = "/pastEvents", method = RequestMethod.GET)
    public String getPastEvents(Model model) {
        model.addAttribute("pastEvents", eventService.findPastEvents());
        return "/events/pastEvents";
    }

    @RequestMapping(value = "/{eventId}", method = RequestMethod.GET)
    public String getEventById(@PathVariable int eventId, Model model) {
        model.addAttribute("event", eventService.findEventById(eventId));
        return "/events/eventView";
    }

    @RequestMapping(value = "/{eventId}/flyer", method = RequestMethod.GET)
    public String getEventFlyer(@PathVariable int eventId, Model model) {
        model.addAttribute("event", eventService.findEventById(eventId));
        return "/events/eventFlyerView";
    }

    @RequestMapping(value = "/edit/{eventId}", method = RequestMethod.GET)
    public String editEventById(@PathVariable int eventId, Model model) {
        model.addAttribute("event", eventService.findEventById(eventId));
        return "/events/eventEditView";
    }

    @RequestMapping(value = "/update/{eventId}", method = RequestMethod.POST)
    public String updateEvent(@PathVariable int eventId, Event event) {
        event.setId(eventId);
        eventService.update(event);
        return "redirect:/index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String createNewEvent() {
        return "/events/eventCreate";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveNewEvent(Event event, ModelMap modelMap) {
        if (eventService.create(event)) {
            modelMap.addAttribute("message", "<h1>Het evenement werd toegevoegd</h1>");
            return "/index";
        } else {
            modelMap.addAttribute("message", "<h1>Het evenement werd niet toegevoegd omdat er al een event gepland staat op die dag !!</h1>");
        }
        return "/index";
    }

    @RequestMapping(value = "/delete/{eventId}", method = RequestMethod.POST)
    public String deleteEvent(@PathVariable int eventId) {
        eventService.delete(eventId);
        return "redirect:/index";
    }

}
