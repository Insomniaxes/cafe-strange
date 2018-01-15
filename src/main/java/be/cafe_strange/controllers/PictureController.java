package be.cafe_strange.controllers;

import be.cafe_strange.interfaces.services.media.PictureService;
import be.cafe_strange.models.Category;
import be.cafe_strange.models.media.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/pictures")
public class PictureController {

    private final String FOLDER = "WEB-INF/components/media/picture/";
    private final String VIEW = "/media";
    private String pageTitle;

    @ModelAttribute("pageTitle")
    public String getPageTitle() {
        pageTitle = "Foto's";
        return pageTitle;
    }


    @Autowired
    private PictureService pictureService;

    @RequestMapping(method = RequestMethod.GET)
    public String getGallery(Model model) {
        model.addAttribute("page", FOLDER + "pictures");
        List<Picture> pictures = pictureService.findAll();
        model.addAttribute("pictures", pictures);
        return VIEW;
    }

    @RequestMapping(value = "delete/{pictureId}", method = RequestMethod.POST)
    public String deltePicture(@PathVariable int pictureId, Model model) {
        pictureService.delete(pictureService.findById(pictureId));
        model.addAttribute("page", FOLDER + "pictures");
        List<Picture> pictures = pictureService.findAll();
        model.addAttribute("pictures", pictures);
        return VIEW;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newPictures(Model model) {
        model.addAttribute("page", FOLDER + "pictures");
        return VIEW;
    }

    @RequestMapping(value = "/uploadMultiple", method = RequestMethod.POST)
    public String uploadMultiplePictures(List<MultipartFile> multipartFiles, String category, Model model) {
        // todo nog folder aanpasmogelijkheid
        Category theCategory = new Category(category);
        model.addAttribute("pictures", pictureService.uploadMultiple(multipartFiles, "temp", theCategory));
        model.addAttribute("page", FOLDER + "pictures");
        return "redirect:/pictures";
    }

}
