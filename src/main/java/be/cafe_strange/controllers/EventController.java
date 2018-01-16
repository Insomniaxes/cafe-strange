package be.cafe_strange.controllers;

import be.cafe_strange.interfaces.services.CommentService;
import be.cafe_strange.interfaces.services.UserService;
import be.cafe_strange.models.Comment;
import be.cafe_strange.models.Event;
import be.cafe_strange.interfaces.services.EventService;
import be.cafe_strange.interfaces.services.CategoryService;
import be.cafe_strange.interfaces.services.media.PictureService;
import be.cafe_strange.models.media.Picture;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.Collections;

@Controller
@RequestMapping("/events")
public class EventController {

    private final String FOLDER = "WEB-INF/components/events/";
    private final String VIEW = "/events";
    private String pageTitle;

    @Autowired
    private EventService eventService;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;

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

    @PreAuthorize("hasAnyRole('ADMIN','MASTER')")
    @RequestMapping(value = "/edit/{eventId}", method = RequestMethod.GET)
    public String editEvent(@PathVariable int eventId, Model model) {
        model.addAttribute("page", FOLDER + "eventEditForm");
        model.addAttribute("event", eventService.findById(eventId));
        model.addAttribute("pageTitle", "Evenement aanpassen");
        return VIEW;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MASTER')")
    @RequestMapping(value = "/update/{eventId}", method = RequestMethod.POST)
    public String updateEvent(@PathVariable int eventId,
                              @RequestParam(value = "file", required = false) MultipartFile file,
                              Event event, Model model) {
        event.setId(eventId);
        event.setPicture(pictureService.uploadPicture(file, "event", categoryService.findById(1)));
        eventService.update(event);
        model.addAttribute("page", FOLDER + "event");
        return "redirect:/events/" + eventId;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MASTER')")
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String createNewEvent(Model model) {
        model.addAttribute("page", FOLDER + "eventCreateForm");
        return VIEW;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MASTER')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveNewEvent(@RequestParam(value = "file", required = false) MultipartFile file,
                               Event event, Model model) {

        if (eventService.eventDateFree(event.getDate())) {
            event.setPicture(pictureService.uploadPicture(file, "event", categoryService.findById(1)));
            eventService.create(event);
            return "redirect:/index";
        } else {
            model.addAttribute("error", "<h3>Op deze dag staat er reeds iets gepland</h3>");
            model.addAttribute("event", event);
            createNewEvent(model);
        }
        return VIEW;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MASTER')")
    @RequestMapping(value = "/{eventId}/delete", method = RequestMethod.POST)
    public String deleteEvent(@PathVariable int eventId) {
        // todo nog check maken of het echt verwijderd mag worden
        eventService.delete(eventId);
        return "redirect:/index";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/{eventId}/addComment", method = RequestMethod.POST)
    public String addComment(@PathVariable int eventId, Comment comment, final Principal principal) {
        if (principal != null & StringUtils.isNotBlank(comment.getComment())) {
            Event event = eventService.findById(eventId);
            comment.setUser(userService.findByUsername(principal.getName()));
            commentService.create(event.addComment(comment));
            eventService.update(event);
        }
        return "redirect:/events/" + eventId;
    }

}
