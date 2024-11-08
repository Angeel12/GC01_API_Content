package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.Actor;
import io.swagger.service.ActorService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ActorsApiController implements ActorsApi {

    private static final Logger log = LoggerFactory.getLogger(ActorsApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final ActorService actorService;

    @org.springframework.beans.factory.annotation.Autowired
    public ActorsApiController(ObjectMapper objectMapper, HttpServletRequest request, ActorService actorService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.actorService = actorService;
    }

    @Override
    public ResponseEntity<Actor> addActor(@Parameter(description = "The actor to add", required=true) @Valid @RequestBody Actor body) {
        Actor savedActor = actorService.saveActor(body);
        return new ResponseEntity<>(savedActor, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteActor(@Parameter(description = "The ID of the actor to delete", required=true) @PathVariable("actorId") Integer actorId) {
        actorService.deleteActor(actorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Actor> getActorById(@Parameter(description = "The ID of the actor to retrieve", required=true) @PathVariable("actorId") Integer actorId) {
        Optional<Actor> actor = actorService.getActorById(actorId);
        return actor.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<List<Actor>> getActors() {
        List<Actor> actors = actorService.getAllActors();
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateActor(@Parameter(description = "The ID of the actor to update", required=true) @PathVariable("actorId") Integer actorId, @Parameter(description = "The updated actor data", required=true) @Valid @RequestBody Actor body) {
        body.setId(actorId);
        actorService.saveActor(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}