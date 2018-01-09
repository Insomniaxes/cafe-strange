package be.cafe_strange.controllers;

import be.cafe_strange.models.event.News;
import be.cafe_strange.interfaces.services.NewsService;
import be.cafe_strange.models.event.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/news")
public class NewsController {

    private final String FOLDER = "WEB-INF/components/news";
    private final String VIEW = "/news";
    private String pageTitle;

    @Autowired
    private NewsService newsService;

    @RequestMapping(method = RequestMethod.GET)
    public String getNews(Model model) {
        pageTitle = "Nieuws";
        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("page", FOLDER + "/news");
        model.addAttribute("news", newsService.findAll());
        return VIEW;
    }

    @RequestMapping(value = "/{newsId}", method = RequestMethod.GET)
    public String getNewsById(@PathVariable int newsId, Model model) {
        model.addAttribute("page", FOLDER + "/article");
        model.addAttribute("article", newsService.findById(newsId));
        return VIEW;
    }

    @RequestMapping(value = "/edit/{newsId}", method = RequestMethod.GET)
    public String editArticle(@PathVariable int newsId, Model model) {
        model.addAttribute("page", FOLDER + "/articleForm");
        model.addAttribute("article", newsService.findById(newsId));
        return VIEW;
    }

    @RequestMapping(value = "/update/{newsId}", method = RequestMethod.POST)
    public String updateArticle(@PathVariable int newsId, News news, Model model) {
        news.setId(newsId);
        newsService.update(news);
        model.addAttribute("page", FOLDER + "/article");
        return "redirect:/";
    }

}
