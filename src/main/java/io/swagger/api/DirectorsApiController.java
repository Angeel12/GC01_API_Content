package io.swagger.api;

import io.swagger.model.Director;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-17T11:17:33.178797818Z[GMT]")
@RestController
public class DirectorsApiController implements DirectorsApi {

    private static final Logger log = LoggerFactory.getLogger(DirectorsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public DirectorsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Director> addDirector(@Parameter(in = ParameterIn.DEFAULT, description = "The director to add", required=true, schema=@Schema()) @Valid @RequestBody Director body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {

                return new ResponseEntity<Director>(objectMapper.readValue("{\n  \"name\" : \"name\",\n  \"id\" : 2,\n  \"biography\" : \"biography\",\n  \"birthDate\" : \"birthDate\"\n}", Director.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Director>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Director>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteDirector(@Parameter(in = ParameterIn.PATH, description = "The ID of the director to delete", required=true, schema=@Schema()) @PathVariable("directorId") Integer directorId
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Director> getDirectorById(@Parameter(in = ParameterIn.PATH, description = "The ID of the director to retrieve", required=true, schema=@Schema()) @PathVariable("directorId") Integer directorId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Director>(objectMapper.readValue("{\n  \"name\" : \"name\",\n  \"id\" : 2,\n  \"biography\" : \"biography\",\n  \"birthDate\" : \"birthDate\"\n}", Director.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Director>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Director>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Director>> getDirectors() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Director>>(objectMapper.readValue("[ {\n  \"name\" : \"name\",\n  \"id\" : 2,\n  \"biography\" : \"biography\",\n  \"birthDate\" : \"birthDate\"\n}, {\n  \"name\" : \"name\",\n  \"id\" : 2,\n  \"biography\" : \"biography\",\n  \"birthDate\" : \"birthDate\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Director>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Director>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateDirector(@Parameter(in = ParameterIn.PATH, description = "The ID of the director to update", required=true, schema=@Schema()) @PathVariable("directorId") Integer directorId
,@Parameter(in = ParameterIn.DEFAULT, description = "The updated director data", required=true, schema=@Schema()) @Valid @RequestBody Director body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
