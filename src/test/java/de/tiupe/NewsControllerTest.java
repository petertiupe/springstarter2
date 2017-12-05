package de.tiupe;

import de.eiswind.training.spring.mvc.services.News;
import de.eiswind.training.spring.mvc.services.NewsRepository;
import de.eiswind.training.spring.mvc.web.HomeController;
import de.eiswind.training.spring.mvc.web.NewsController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
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
        List<News> expectedSpittles = new ArrayList<News>();
        for (int i=0; i < 20; i++) {
            expectedSpittles.add(new News("Nachricht " + i, i));
        }
        NewsRepository mockRepository = mock(NewsRepository.class);
        when(mockRepository.findNews( 20)).thenReturn(expectedSpittles);
        NewsController controller = new NewsController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();
        mockMvc.perform(get("/news"))
                .andExpect(view().name("news"))
                .andExpect(model().attributeExists("newsList"))
                .andExpect(model().attribute("newsList", hasItems(expectedSpittles.toArray())));
    }
}