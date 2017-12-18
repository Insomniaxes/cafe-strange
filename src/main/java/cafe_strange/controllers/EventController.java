package cafe_strange.controllers;

import cafe_strange.interfaces.services.EventService;
import cafe_strange.models.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.GET)
    public String getEventPage(Model model) {
        model.addAttribute("upcomingEvents", eventService.findUpcomingEvents());
        model.addAttribute("pastEvents", eventService.findPastEvents());
        return "views/event/events";
    }

    @RequestMapping(value = "/{eventId}", method = RequestMethod.GET)
    public String getEventById(@PathVariable int eventId, Model model) {
        model.addAttribute("event", eventService.findEventById(eventId));
        return "views/event/eventView";
    }

    @RequestMapping(value = "/edit/{eventId}", method = RequestMethod.GET)
    public String editEventById(@PathVariable int eventId, Model model) {
        model.addAttribute("event", eventService.findEventById(eventId));
        return "views/event/eventDetailsEdit";
    }

    @RequestMapping(value = "/update/{eventId}", method = RequestMethod.POST)
    public String updateEvent(@PathVariable int eventId, Event event) {
        event.setId(eventId);
        eventService.update(event);
        return "redirect:/index";
    }

    @RequestMapping(value = "/createNew", method = RequestMethod.GET)
    public String createNewEvent() {
        return "views/event/eventDetailsEdit";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveNewEvent(Event event) {
        eventService.create(event);
        return "redirect:/index";
    }

}
