package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.Director;
import io.swagger.service.DirectorService;
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
public class DirectorsApiController implements DirectorsApi {

    private static final Logger log = LoggerFactory.getLogger(DirectorsApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final DirectorService directorService;

    @org.springframework.beans.factory.annotation.Autowired
    public DirectorsApiController(ObjectMapper objectMapper, HttpServletRequest request, DirectorService directorService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.directorService = directorService;
    }

    @Override
    public ResponseEntity<Director> addDirector(@Parameter(description = "The director to add", required=true) @Valid @RequestBody Director body) {
        Director savedDirector = directorService.saveDirector(body);
        return new ResponseEntity<>(savedDirector, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteDirector(@Parameter(description = "The ID of the director to delete", required=true) @PathVariable("directorId") Integer directorId) {
        directorService.deleteDirector(directorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Director> getDirectorById(@Parameter(description = "The ID of the director to retrieve", required=true) @PathVariable("directorId") Integer directorId) {
        Optional<Director> director = directorService.getDirectorById(directorId);
        return director.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<List<Director>> getDirectors() {
        List<Director> directors = directorService.getAllDirectors();
        return new ResponseEntity<>(directors, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateDirector(@Parameter(description = "The ID of the director to update", required=true) @PathVariable("directorId") Integer directorId, @Parameter(description = "The updated director data", required=true) @Valid @RequestBody Director body) {
        body.setId(directorId);
        directorService.saveDirector(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}