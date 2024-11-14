package io.swagger.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
    private Content mockContent; // Definición de la variable de clase

    @BeforeEach
    public void setUp() {
        // Instancia y configuración del objeto mockContent
        mockContent = new Content();
        mockContent.setId(1);
        mockContent.setType("movie");
        mockContent.setTitle("Inception");
        mockContent.setSynopsis("A mind-bending thriller");
        mockContent.setReleaseYear(2010);
        mockContent.setDuration(148);
        mockContent.setCoverImage("inception.jpg");
        mockContent.setGenre("action");
        mockContent.setActorIds(Arrays.asList(101, 102));
        mockContent.setDirectorIds(Arrays.asList(201));
        mockContent.setLanguage("English");
        mockContent.setStatus("public");

        // Configuración de otros contenidos para listas
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
        mockContents = Arrays.asList(mockContent, content2, content3);
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

    @Test
    public void testGetContentById() throws Exception {
        // Configura el comportamiento simulado para obtener un contenido por ID
        when(contentService.getContentById(1)).thenReturn(Optional.of(mockContent));

        // Prueba el endpoint para obtener contenido por ID
        mockMvc.perform(get("/contents/1")) // Asegúrate de que la URL sea coherente
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.type").value("movie"))
                .andExpect(jsonPath("$.title").value("Inception"))
                .andExpect(jsonPath("$.releaseYear").value(2010))
                .andExpect(jsonPath("$.duration").value(148))
                .andExpect(jsonPath("$.genre").value("action"))
                .andExpect(jsonPath("$.status").value("public"));
    }

    @Test
    public void testGetContentByIdNotFound() throws Exception {
        // Configura el comportamiento simulado para un ID que no existe
        when(contentService.getContentById(999)).thenReturn(Optional.empty());

        // Prueba el endpoint para un contenido que no existe
        mockMvc.perform(get("/contents/999"))
                .andExpect(status().isNotFound());
    }
}
