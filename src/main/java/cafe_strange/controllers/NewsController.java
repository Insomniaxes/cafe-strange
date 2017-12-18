package cafe_strange.controllers;

import cafe_strange.interfaces.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(method = RequestMethod.GET)
    public String getNews(Model model) {
        model.addAttribute("newsList", newsService.findAllNews());
        return "views/events/news";
    }

    @RequestMapping(value = "/{newsId}", method = RequestMethod.GET)
    public String getNewsById(@PathVariable int newsId, Model model) {
        model.addAttribute("news", newsService.findById(newsId));
        return "views/events/article";
    }

}
