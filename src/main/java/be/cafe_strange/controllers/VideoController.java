package be.cafe_strange.controllers;

import be.cafe_strange.enums.MediaType;
import be.cafe_strange.interfaces.services.media.VideoService;
import be.cafe_strange.models.media.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/videos")
public class VideoController {

    private final String FOLDER = "WEB-INF/components/media/video";
    private final String VIEW = "/media";
    private final MediaType mediaType = MediaType.VIDEO;
    private String pageTitle;

    @Autowired
    private VideoService videoService;

    @ModelAttribute("pageTitle")
    public String getPageTitle() {
        pageTitle = "Video's";
        return pageTitle;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getGallery(Model model) {
        model.addAttribute("page", FOLDER + "/videos");
        model.addAttribute("media", videoService.findAll());
        return VIEW;
    }

    @RequestMapping(value = "/{videoId}", method = RequestMethod.GET)
    public String getVideoById(@PathVariable int videoId, Model model) {
        model.addAttribute("page", FOLDER + "/video");
        model.addAttribute("video", videoService.findById(videoId));
        return VIEW;
    }

    @RequestMapping(value = "/edit/{videoId}", method = RequestMethod.GET)
    public String getEditView(@PathVariable int videoId, Model model) {
        model.addAttribute("page", FOLDER + "/videoForm");
        model.addAttribute("video", videoService.findById(videoId));
        return VIEW;
    }

    @RequestMapping(value = "/update/{videoId}", method = RequestMethod.POST)
    public String updateVideo(@PathVariable int videoId, Video video, Model model) {
        video.setId(videoId);
        video.setMediaType(mediaType);
        videoService.update(video);
        model.addAttribute("page", FOLDER + "/video");
        model.addAttribute("video", videoService.findById(videoId));
        return VIEW;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getCreateView(Model model) {
        model.addAttribute("page", FOLDER + "/videoCreateForm");
        return VIEW;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createVideo(Video video, Model model) {
        video.setMediaType(mediaType);
        videoService.create(video);
        model.addAttribute("page", FOLDER + "/videos");
        return VIEW;
    }

}
