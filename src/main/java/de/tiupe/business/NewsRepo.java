package de.tiupe.business;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class NewsRepo implements NewsRepository {

    public List<News> newsList;

    public void addNews(News aNews){
        this.newsList.add(aNews);
    }

    public List<News> getAllNews(){
        return this.newsList;
    }

    public List<News> getNumberOfNews(Integer number){
        List<News> lstToReturn = new ArrayList<News>();
        for(int i = 0; i < number; ++ i){
            News myNews = new News("Peter wars", "Heute war es Peter", LocalDateTime.now());
            lstToReturn.add(myNews);
        }
        return lstToReturn;
    }

}
