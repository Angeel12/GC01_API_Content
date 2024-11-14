package io.swagger.api;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.Content;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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

    @Test
    public void testCreateContent() throws Exception {
        // Configuramos un nuevo objeto de tipo Content para añadir
        Content newContent = new Content();
        newContent.setType("movie");
        newContent.setTitle("Interstellar");
        newContent.setSynopsis("A journey through space and time.");
        newContent.setReleaseYear(2014);
        newContent.setDuration(169);
        newContent.setCoverImage("interstellar.jpg");
        newContent.setGenre("sci-fi");
        newContent.setActorIds(Arrays.asList(201, 202));
        newContent.setDirectorIds(Arrays.asList(301));
        newContent.setLanguage("English");
        newContent.setStatus("public");

        // Configuramos el servicio para que devuelva el contenido que hemos añadido
        when(contentService.saveContent(newContent)).thenReturn(newContent);

        // Realizamos la prueba del endpoint POST
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/contents")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newContent)))
                .andExpect(status().isCreated()); // Verificamos que se devuelve el código 201 Created
    }


    @Test
    public void testUpdateContent() throws Exception {
        // Configuramos un objeto de tipo Content existente
        Content existingContent = new Content();
        existingContent.setId(1);
        existingContent.setType("movie");
        existingContent.setTitle("Inception");
        existingContent.setSynopsis("A mind-bending thriller");
        existingContent.setReleaseYear(2010);
        existingContent.setDuration(148);
        existingContent.setCoverImage("inception.jpg");
        existingContent.setGenre("action");
        existingContent.setActorIds(Arrays.asList(101, 102));
        existingContent.setDirectorIds(Arrays.asList(201));
        existingContent.setLanguage("English");
        existingContent.setStatus("public");

        // Configuramos el contenido actualizado
        Content updatedContent = new Content();
        updatedContent.setId(1);
        updatedContent.setType("movie");
        updatedContent.setTitle("Inception: The Update");
        updatedContent.setSynopsis("An updated mind-bending thriller");
        updatedContent.setReleaseYear(2010);
        updatedContent.setDuration(150);
        updatedContent.setCoverImage("inception_updated.jpg");
        updatedContent.setGenre("action");
        updatedContent.setActorIds(Arrays.asList(101, 103));
        updatedContent.setDirectorIds(Arrays.asList(201));
        updatedContent.setLanguage("English");
        updatedContent.setStatus("public");

        // Configuramos el comportamiento del servicio para devolver el contenido existente y el actualizado
        when(contentService.getContentById(1)).thenReturn(Optional.of(existingContent));
        when(contentService.saveContent(updatedContent)).thenReturn(updatedContent);

        // Realizamos la prueba del endpoint PUT
        ObjectMapper objectMapper=new ObjectMapper();
        mockMvc.perform(put("/contents/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedContent)))
                .andExpect(status().isOk()) // Verificamos que se devuelve el código 200 OK
                .andExpect(jsonPath("$.title").value("Inception: The Update")) // Verificamos el título actualizado
                .andExpect(jsonPath("$.synopsis").value("An updated mind-bending thriller")) // Verificamos la sinopsis actualizada
                .andExpect(jsonPath("$.duration").value(150)); // Verificamos la duración actualizada
    }


    @Test
    public void testDeleteContent() throws Exception {
        // Configuramos el comportamiento simulado del servicio para eliminar un contenido
        // No es necesario devolver nada, solo verificar que el método de servicio fue llamado

        // Realizamos la prueba del endpoint DELETE
        mockMvc.perform(delete("/contents/1"))
                .andExpect(status().isNoContent()); // Verificamos que se devuelve el código 204 No Content

        // Verificamos que el servicio haya sido llamado para eliminar el contenido con ID 1
        verify(contentService).deleteContent(1);
    }

    @Test
    public void testUpdateContentStatus() throws Exception {
        // Configuramos un objeto de tipo Content existente
        Content existingContent = new Content();
        existingContent.setId(1);
        existingContent.setType("movie");
        existingContent.setTitle("Inception");
        existingContent.setSynopsis("A mind-bending thriller");
        existingContent.setReleaseYear(2010);
        existingContent.setDuration(148);
        existingContent.setCoverImage("inception.jpg");
        existingContent.setGenre("action");
        existingContent.setActorIds(Arrays.asList(101, 102));
        existingContent.setDirectorIds(Arrays.asList(201));
        existingContent.setLanguage("English");
        existingContent.setStatus("public");

        // Configuramos el contenido actualizado con un nuevo estado
        Content updatedContent = new Content();
        updatedContent.setId(1);
        updatedContent.setType("movie");
        updatedContent.setTitle("Inception");
        updatedContent.setSynopsis("A mind-bending thriller");
        updatedContent.setReleaseYear(2010);
        updatedContent.setDuration(148);
        updatedContent.setCoverImage("inception.jpg");
        updatedContent.setGenre("action");
        updatedContent.setActorIds(Arrays.asList(101, 102));
        updatedContent.setDirectorIds(Arrays.asList(201));
        updatedContent.setLanguage("English");
        updatedContent.setStatus("private"); // Cambio de estado

        // Configuramos el comportamiento del servicio para devolver el contenido existente y el actualizado
        when(contentService.getContentById(1)).thenReturn(Optional.of(existingContent));
        when(contentService.saveContent(updatedContent)).thenReturn(updatedContent);

        // Realizamos la prueba del endpoint PUT para actualizar el estado
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(put("/contents/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedContent)))
                .andExpect(status().isOk()) // Verificamos que se devuelve el código 200 OK
                .andExpect(jsonPath("$.status").value("private")); // Verificamos que el estado fue actualizado correctamente
    }





}
