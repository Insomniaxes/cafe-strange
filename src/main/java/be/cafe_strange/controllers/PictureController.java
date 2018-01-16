package be.cafe_strange.controllers;

import be.cafe_strange.interfaces.services.CommentService;
import be.cafe_strange.interfaces.services.UserService;
import be.cafe_strange.interfaces.services.media.PictureService;
import be.cafe_strange.models.Category;
import be.cafe_strange.models.Comment;
import be.cafe_strange.models.media.Picture;
import be.cafe_strange.models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pictures")
public class PictureController {

    private final String FOLDER = "WEB-INF/components/media/picture/";
    private final String VIEW = "/media";
    private String pageTitle;
    @Autowired
    private UserService userService;

    @ModelAttribute("pageTitle")
    public String getPageTitle() {
        pageTitle = "Foto's";
        return pageTitle;
    }


    @Autowired
    private PictureService pictureService;
    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.GET)
    public String getGallery(Model model) {
        model.addAttribute("page", FOLDER + "pictures");
        List<Picture> pictures = pictureService.findAll();
        model.addAttribute("pictures", pictures);
        return VIEW;
    }

    @RequestMapping(value = "/{pictureId}", method = RequestMethod.GET)
    public String getPicture(@PathVariable int pictureId, Model model) {
        model.addAttribute("page", FOLDER + "picture");
        Picture picture = pictureService.findById(pictureId);
        model.addAttribute("picture", picture);
        return VIEW;
    }

    @RequestMapping(value = "/{pictureId}/addComment", method = RequestMethod.POST)
    public String addComment(@PathVariable int pictureId, final Principal principal, Comment comment, Model model) {
        Picture picture = pictureService.findById(pictureId);
        model.addAttribute("page", "picture");
        if (principal == null) {
            return "redirect:/pictures/" + pictureId;
        } else {
            comment.setUser(userService.findByUsername(principal.getName()));
            commentService.create(comment);
            List<Comment> comments = picture.getComments();
            comments.add(comment);
            picture.setComments(comments);
            pictureService.update(picture);
            model.addAttribute("picture", picture);
        }
        return "redirect:/pictures/" + pictureId ;
    }

    @RequestMapping(value = "/delete/{pictureId}", method = RequestMethod.POST)
    public String deletePicture(@PathVariable int pictureId, Model model) {
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
