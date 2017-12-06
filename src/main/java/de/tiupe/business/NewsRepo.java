package de.tiupe.business;

import org.springframework.cache.annotation.Cacheable;
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

    public List<News> getAllNews() {
        if(newsList.isEmpty()){
            return this.getNumberOfNews(100);
        }else{
            return this.newsList;
        }

    }

    @Cacheable("newsCache")
    public List<News> getNumberOfNews(Integer number){

        List<News> lstToReturn = new ArrayList<News>();
        try{
            Thread.sleep(6000);
        }catch(Exception ex){
            System.out.println("Fehler beim Schlafen");
        }
        for(int i = 0; i < number; ++ i){
            News myNews = new News("Peter wars", "Heute war es Peter", LocalDateTime.now());
            lstToReturn.add(myNews);
        }
        return lstToReturn;
    }

}
