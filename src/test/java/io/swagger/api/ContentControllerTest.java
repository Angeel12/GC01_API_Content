package io.swagger.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;
import java.util.List;

import io.swagger.model.Content;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import io.swagger.service.ContentService;

@SpringBootTest
@AutoConfigureMockMvc
public class ContentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContentService contentService;

    private List<Content> mockContents;

    @BeforeEach
    public void setUp() {
        // Instanciamos y configuramos objetos Content usando setters
        Content content1 = new Content();
        content1.setId(1);
        content1.setType("movie");
        content1.setTitle("Inception");
        content1.setSynopsis("A mind-bending thriller");
        content1.setReleaseYear(2010);
        content1.setDuration(148);
        content1.setCoverImage("inception.jpg");
        content1.setGenre("action");
        content1.setActorIds(Arrays.asList(101, 102));
        content1.setDirectorIds(Arrays.asList(201));
        content1.setLanguage("English");
        content1.setStatus("public");

        Content content2 = new Content();
        content2.setId(2);
        content2.setType("series");
        content2.setTitle("Breaking Bad");
        content2.setSynopsis("A high school teacher turns to crime");
        content2.setReleaseYear(2008);
        content2.setDuration(60);
        content2.setCoverImage("breakingbad.jpg");
        content2.setGenre("drama");
        content2.setActorIds(Arrays.asList(103, 104));
        content2.setDirectorIds(Arrays.asList(202));
        content2.setLanguage("English");
        content2.setStatus("public");

        Content content3 = new Content();
        content3.setId(3);
        content3.setType("documentary");
        content3.setTitle("Planet Earth");
        content3.setSynopsis("Exploration of nature's beauty");
        content3.setReleaseYear(2006);
        content3.setDuration(50);
        content3.setCoverImage("planetearth.jpg");
        content3.setGenre("documentary");
        content3.setLanguage("English");
        content3.setStatus("public");

        // Configuramos la lista simulada de contenidos
        mockContents = Arrays.asList(content1, content2, content3);
    }

    @Test
    public void testRecuperarContenidos() throws Exception {
        // Configura el comportamiento simulado del servicio
        when(contentService.getAllContents()).thenReturn(mockContents);

        // Prueba el endpoint
        mockMvc.perform(get("/contents"))
                .andExpect(status().isOk()) // Verifica que el estado de la respuesta es 200 OK
                .andExpect(jsonPath("$.length()").value(3)) // Verifica que la respuesta contiene 3 elementos
                .andExpect(jsonPath("$[0].id").value(1)) // Verifica los campos del primer elemento
                .andExpect(jsonPath("$[0].type").value("movie"))
                .andExpect(jsonPath("$[0].title").value("Inception"))
                .andExpect(jsonPath("$[0].releaseYear").value(2010))
                .andExpect(jsonPath("$[0].duration").value(148))
                .andExpect(jsonPath("$[0].genre").value("action"))
                .andExpect(jsonPath("$[0].status").value("public"))
                .andExpect(jsonPath("$[1].title").value("Breaking Bad"))
                .andExpect(jsonPath("$[2].title").value("Planet Earth"));
    }
}
