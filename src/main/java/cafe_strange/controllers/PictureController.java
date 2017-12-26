package cafe_strange.controllers;

import cafe_strange.interfaces.services.media.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/pictures")
public class PictureController {

    @Autowired
    private MediaService mediaService;

    @RequestMapping(method = RequestMethod.GET)
    public String getGallery(Model model) {
        model.addAttribute("pictures", mediaService.findAllPictures());
        return "/media/picture/pictureOverview";
    }

}
