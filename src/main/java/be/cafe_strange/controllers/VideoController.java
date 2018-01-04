package be.cafe_strange.controllers;

import be.cafe_strange.interfaces.services.media.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/videos")
public class VideoController {

    private final String FOLDER = "WEB-INF/components/media/";
    private final String VIEW = "/media/media";
    private String pageTitle;

    @Autowired
    private VideoService videoService;

    @RequestMapping(method = RequestMethod.GET)
    public String getGallery(Model model) {
        pageTitle = "Video's";
        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("page", FOLDER + "mediaOverview");
        model.addAttribute("media", videoService.findAll());
        return VIEW;
    }

}
