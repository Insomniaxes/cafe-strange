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

    @Autowired
    private NewsService newsService;

    @RequestMapping(method = RequestMethod.GET)
    public String getNews(Model model) {
        model.addAttribute("newsList", newsService.findAll());
        return "/news/news";
    }

    @RequestMapping(value = "/{newsId}", method = RequestMethod.GET)
    public String getNewsById(@PathVariable int newsId, Model model) {
        model.addAttribute("news", newsService.findById(newsId));
        return "/news/article";
    }

    @RequestMapping(value = "/edit/{newsId}", method = RequestMethod.GET)
    public String editNews(News news, Model model) {
        model.addAttribute("news", news);
        return "news/newsEdit";
    }

}
