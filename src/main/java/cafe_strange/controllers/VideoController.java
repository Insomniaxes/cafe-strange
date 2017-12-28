package cafe_strange.controllers;

import cafe_strange.interfaces.services.media.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/videos")
public class VideoController {

    private final String FOLDER = "components/media/video/";

    @Autowired
    private VideoService videoService;

    @RequestMapping(method = RequestMethod.GET)
    public String getGallery(Model model) {
        model.addAttribute("page", FOLDER + "videoOverview");
        model.addAttribute("videos", videoService.findAll());
        return "/media/media";
    }

}
