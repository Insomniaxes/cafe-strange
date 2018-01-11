package be.cafe_strange.controllers;

import be.cafe_strange.models.Event;
import be.cafe_strange.interfaces.services.EventService;
import be.cafe_strange.interfaces.services.CategoryService;
import be.cafe_strange.interfaces.services.media.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;

@Controller
@RequestMapping("/events")
public class EventController {

    private final String FOLDER = "WEB-INF/components/events/";
    private final String VIEW = "/event";
    private String pageTitle;

    @Autowired
    private EventService eventService;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("pageTitle")
    public String getPageTitle() {
        pageTitle = "Evenementen";
        return pageTitle;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getEvents(Model model) {
        model.addAttribute("page", FOLDER + "events");
        model.addAttribute("events", eventService.sortLastFirst(eventService.findAll()));
        return VIEW;
    }

    @RequestMapping(method = RequestMethod.GET, params = "argName")
    public String getEventsPage(Model model, @RequestParam(value = "argName") String page) {
        model.addAttribute("page", FOLDER + "events");
        switch (page) {
            case "upcoming":
                pageTitle = "Aankomende evenementen";
                model.addAttribute("events", eventService.findUpcoming());
                break;
            case "past":
                pageTitle = "Afgelopen evenementen";
                model.addAttribute("events", eventService.sortLastFirst(eventService.findPast()));
                break;
            case "all":
                model.addAttribute("events", eventService.sortLastFirst(eventService.findAll()));
                break;
            default:
                System.out.println("something went wrong");
        }
        model.addAttribute("pageTitle", pageTitle);
        return VIEW;
    }

    @RequestMapping(value = "/{eventId}", method = RequestMethod.GET)
    public String getEventById(@PathVariable int eventId, Model model) {
        model.addAttribute("page", FOLDER + "event");
        model.addAttribute("event", eventService.findById(eventId));
        return VIEW;
    }

    @RequestMapping(value = "/flyer/{eventId}", method = RequestMethod.GET)
    public String getEventFlyer(@PathVariable int eventId, Model model) {
        model.addAttribute("page", FOLDER + "eventFlyer");
        model.addAttribute("event", eventService.findById(eventId));
        return VIEW;
    }

    @PreAuthorize("hasAnyRole('ADMIN','OWNER')")
    @RequestMapping(value = "/edit/{eventId}", method = RequestMethod.GET)
    public String editEvent(@PathVariable int eventId, Model model) {
        model.addAttribute("page", FOLDER + "eventForm");
        model.addAttribute("event", eventService.findById(eventId));
        model.addAttribute("pageTitle", "Evenement aanpassen");
        return VIEW;
    }

    @RequestMapping(value = "/update/{eventId}", method = RequestMethod.POST)
    public String updateEvent(@PathVariable int eventId,
                              @RequestParam(value = "file", required = false) MultipartFile file,
                              Event event, Model model) {
        event.setId(eventId);
        if (file != null) {
            // todo nog mogelijkheid maken voor category
            event.setPicture(pictureService.uploadPicture(file, "event", categoryService.findById(1)));
        }
        eventService.update(event);
        model.addAttribute("page", FOLDER + "event");
        System.out.println("update van event");
        return VIEW;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String createNewEvent(Model model) {
        model.addAttribute("page", FOLDER + "eventForm");
        return VIEW;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveNewEvent(@RequestParam(value = "file", required = false) MultipartFile file,
                               Event event, Model model) {

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
        System.out.println("redirecting");
        return "redirect:/index";
    }

    @RequestMapping(value = "/delete/{eventId}", method = RequestMethod.POST)
    public String deleteEvent(@PathVariable int eventId) {
        // todo nog check maken of het echt verwijderd mag worden
        eventService.delete(eventId);
        return "redirect:/index";
    }

}
