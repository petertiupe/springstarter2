package de.tiupe.controller;


import de.tiupe.business.NewsRepo;
import de.tiupe.business.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/news")
public class NewsController {

    public void setNewsRepo(NewsRepository aNewsRepos){
        this.newsRepo = aNewsRepos;
    }

    @Autowired
    private NewsRepository newsRepo;

    @RequestMapping(method = RequestMethod.GET, value="/numberOfNews")
    public String getNumberOfNews(Model model) {
        model.addAttribute("newList", newsRepo.getNumberOfNews(20));
        return "news";
    }

    @RequestMapping(method = RequestMethod.GET, value="/allNews")
    public String getAllNews(Model model) {
        model.addAttribute("newList", newsRepo.getAllNews());
        return "news";
    }

    @RequestMapping(method = RequestMethod.GET, value="/paramNumberOfNews")
    public String getAllNews(Model model, @RequestParam(name="count", defaultValue = "10") int anzahl) {
        model.addAttribute("newList", newsRepo.getNumberOfNews(anzahl));
        return "news";
    }

}
