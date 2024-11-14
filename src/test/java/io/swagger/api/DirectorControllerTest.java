package io.swagger.api;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import io.swagger.model.Director;
import io.swagger.service.DirectorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
public class DirectorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DirectorService directorService;

    @Autowired
    private ObjectMapper objectMapper;

    private Director mockDirector;

    @BeforeEach
    public void setUp() {
        mockDirector = new Director();
        mockDirector.setId(1);
        mockDirector.setName("Jane Smith");
        mockDirector.setBiography("A renowned director.");
    }

    @Test
    public void testGetDirectorById() throws Exception {
        when(directorService.getDirectorById(1)).thenReturn(Optional.of(mockDirector));

        mockMvc.perform(get("/directors/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Jane Smith"))
                .andExpect(jsonPath("$.biography").value("A renowned director."));
    }

    @Test
    public void testCreateDirector() throws Exception {
        when(directorService.saveDirector(mockDirector)).thenReturn(mockDirector);

        mockMvc.perform(post("/directors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mockDirector)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateDirector() throws Exception {
        when(directorService.getDirectorById(1)).thenReturn(Optional.of(mockDirector));
        when(directorService.saveDirector(mockDirector)).thenReturn(mockDirector);

        mockDirector.setBiography("Updated biography.");

        mockMvc.perform(put("/directors/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mockDirector)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.biography").value("Updated biography."));
    }

    @Test
    public void testDeleteDirector() throws Exception {
        mockMvc.perform(delete("/directors/1"))
                .andExpect(status().isNoContent());

        verify(directorService).deleteDirector(1);
    }
}
