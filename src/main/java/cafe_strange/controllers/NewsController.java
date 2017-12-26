package cafe_strange.controllers;

import cafe_strange.interfaces.services.NewsService;
import cafe_strange.models.event.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/news")
public class NewsController {

    private final String FOLDER = "components/news/";
    private final String VIEW = "/news/news";

    @Autowired
    private NewsService newsService;

    @RequestMapping(method = RequestMethod.GET)
    public String getNews(Model model) {
        model.addAttribute("page", FOLDER + "news");
        model.addAttribute("newsList", newsService.findAll());
        return VIEW;
    }

    @RequestMapping(value = "/{newsId}", method = RequestMethod.GET)
    public String getNewsById(@PathVariable int newsId, Model model) {
        model.addAttribute("page", FOLDER + "article");
        model.addAttribute("news", newsService.findById(newsId));
        return VIEW;
    }

    @RequestMapping(value = "/edit/{newsId}", method = RequestMethod.GET)
    public String editNews(News news, Model model) {
        model.addAttribute("page", FOLDER + "newsEdit");
        model.addAttribute("news", news);
        return VIEW;
    }

}
