package io.swagger.api;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import io.swagger.model.Actor;
import io.swagger.service.ActorService;
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
public class ActorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ActorService actorService;

    @Autowired
    private ObjectMapper objectMapper;

    private Actor mockActor;

    @BeforeEach
    public void setUp() {
        mockActor = new Actor();
        mockActor.setId(1);
        mockActor.setName("John Doe");
        mockActor.setBiography("A famous actor known for numerous roles.");
    }

    @Test
    public void testGetActorById() throws Exception {
        when(actorService.getActorById(1)).thenReturn(Optional.of(mockActor));

        mockMvc.perform(get("/actors/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.biography").value("A famous actor known for numerous roles."));
    }

    @Test
    public void testCreateActor() throws Exception {
        when(actorService.saveActor(mockActor)).thenReturn(mockActor);

        mockMvc.perform(post("/actors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mockActor)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateActor() throws Exception {
        when(actorService.getActorById(1)).thenReturn(Optional.of(mockActor));
        when(actorService.saveActor(mockActor)).thenReturn(mockActor);

        mockActor.setBiography("Updated biography for the actor.");

        mockMvc.perform(put("/actors/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mockActor)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.biography").value("Updated biography for the actor."));
    }

    @Test
    public void testDeleteActor() throws Exception {
        mockMvc.perform(delete("/actors/1"))
                .andExpect(status().isNoContent());

        verify(actorService).deleteActor(1);
    }
}
