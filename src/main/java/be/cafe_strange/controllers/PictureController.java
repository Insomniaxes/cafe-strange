package be.cafe_strange.controllers;

import be.cafe_strange.interfaces.services.media.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/pictures")
public class PictureController {

    private final String FOLDER = "WEB-INF/components/media/picture/";
    private final String VIEW = "/media";
    private String pageTitle;

    @Autowired
    private PictureService pictureService;

    @RequestMapping(method = RequestMethod.GET)
    public String getGallery(Model model) {
        pageTitle = "Foto's";
        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("page", FOLDER + "pictures");
        model.addAttribute("media", pictureService.findAll());
        return VIEW;
    }

}
