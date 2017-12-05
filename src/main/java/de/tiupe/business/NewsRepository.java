package de.tiupe.business;


import java.util.List;

public interface NewsRepository {
    public void addNews(News aNews);

    public List<News> getAllNews();

    public List<News> getNumberOfNews(Integer number);
}
