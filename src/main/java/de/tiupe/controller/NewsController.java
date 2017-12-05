package de.tiupe.controller;


import de.tiupe.business.NewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsRepo newsRepo;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllNews(Model model) {
        model.addAttribute("newList", newsRepo.getNumberOfNews(20));
        return "news";
    }

}
