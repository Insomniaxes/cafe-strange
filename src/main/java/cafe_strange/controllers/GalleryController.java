package cafe_strange.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

    @RequestMapping(method = RequestMethod.GET)
    public String getGallery() {
        return "views/gallery/gallery";
    }

}
