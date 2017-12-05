package de.tiupe;

import de.tiupe.business.News;
import de.tiupe.business.NewsRepository;
import de.tiupe.controller.NewsController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class NewsControllerTest {
    @Test
    public void shouldShowRecentNews() throws Exception {
        List<News> expectedNews = new ArrayList<News>();
        for (int i=0; i < 20; i++) {
            expectedNews.add(new News("Peter wars", "Heute war es Peter", LocalDateTime.now()));
        }
        NewsRepository mockRepository = mock(NewsRepository.class);
        when(mockRepository.getNumberOfNews(20)).thenReturn(expectedNews);
        NewsController controller = new NewsController();
        controller.setNewsRepo(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/news.jsp"))
                .build();
        mockMvc.perform(get("/news"))
                .andExpect(view().name("news"))
                .andExpect(model().attributeExists("newsList"))
                .andExpect(model().attribute("newsList", hasItems(expectedNews.toArray())));
    }
}