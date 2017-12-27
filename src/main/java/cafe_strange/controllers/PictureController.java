package cafe_strange.controllers;

import cafe_strange.interfaces.services.media.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/pictures")
public class PictureController {

    private final String VIEW = "/media/media";
    private final String FOLDER = "components/media/picture/";

    @Autowired
    private PictureService pictureService;

    @RequestMapping(method = RequestMethod.GET)
    public String getGallery(Model model) {
        model.addAttribute("page", FOLDER + "pictureOverview");
        model.addAttribute("pictures", pictureService.findAll());
        return VIEW;
    }

}
