package io.swagger.api;

import io.swagger.model.Content;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
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
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-17T11:17:33.178797818Z[GMT]")
@RestController
public class ContentsApiController implements ContentsApi {

    private static final Logger log = LoggerFactory.getLogger(ContentsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ContentsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Content> addContent(@Parameter(in = ParameterIn.DEFAULT, description = "The content to add", required=true, schema=@Schema()) @Valid @RequestBody Content body
    ) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Content>(objectMapper.readValue("{\n  \"duration\" : 5,\n  \"actors\" : [ {\n    \"name\" : \"name\",\n    \"id\" : 5,\n    \"biography\" : \"biography\",\n    \"birthDate\" : \"birthDate\"\n  }, {\n    \"name\" : \"name\",\n    \"id\" : 5,\n    \"biography\" : \"biography\",\n    \"birthDate\" : \"birthDate\"\n  } ],\n  \"languages\" : [ \"English\", \"English\" ],\n  \"parentSeriesId\" : 6,\n  \"coverImage\" : \"coverImage\",\n  \"directors\" : [ {\n    \"name\" : \"name\",\n    \"id\" : 2,\n    \"biography\" : \"biography\",\n    \"birthDate\" : \"birthDate\"\n  }, {\n    \"name\" : \"name\",\n    \"id\" : 2,\n    \"biography\" : \"biography\",\n    \"birthDate\" : \"birthDate\"\n  } ],\n  \"genre\" : \"Action\",\n  \"id\" : 0,\n  \"synopsis\" : \"synopsis\",\n  \"type\" : \"movie\",\n  \"title\" : \"title\",\n  \"releaseYear\" : 1\n}", Content.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Content>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Content>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteContent(@Parameter(in = ParameterIn.PATH, description = "The ID of the content to delete", required=true, schema=@Schema()) @PathVariable("contentId") Integer contentId
    ) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Content> getContentById(@Parameter(in = ParameterIn.PATH, description = "The ID of the content to retrieve", required=true, schema=@Schema()) @PathVariable("contentId") Integer contentId
    ) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Content>(objectMapper.readValue("{\n  \"duration\" : 5,\n  \"actors\" : [ {\n    \"name\" : \"name\",\n    \"id\" : 5,\n    \"biography\" : \"biography\",\n    \"birthDate\" : \"birthDate\"\n  }, {\n    \"name\" : \"name\",\n    \"id\" : 5,\n    \"biography\" : \"biography\",\n    \"birthDate\" : \"birthDate\"\n  } ],\n  \"languages\" : [ \"English\", \"English\" ],\n  \"parentSeriesId\" : 6,\n  \"coverImage\" : \"coverImage\",\n  \"directors\" : [ {\n    \"name\" : \"name\",\n    \"id\" : 2,\n    \"biography\" : \"biography\",\n    \"birthDate\" : \"birthDate\"\n  }, {\n    \"name\" : \"name\",\n    \"id\" : 2,\n    \"biography\" : \"biography\",\n    \"birthDate\" : \"birthDate\"\n  } ],\n  \"genre\" : \"Action\",\n  \"id\" : 0,\n  \"synopsis\" : \"synopsis\",\n  \"type\" : \"movie\",\n  \"title\" : \"title\",\n  \"releaseYear\" : 1\n}", Content.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Content>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Content>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Content>> getContents() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Content>>(objectMapper.readValue("[ {\n  \"duration\" : 5,\n  \"actors\" : [ {\n    \"name\" : \"name\",\n    \"id\" : 5,\n    \"biography\" : \"biography\",\n    \"birthDate\" : \"birthDate\"\n  }, {\n    \"name\" : \"name\",\n    \"id\" : 5,\n    \"biography\" : \"biography\",\n    \"birthDate\" : \"birthDate\"\n  } ],\n  \"languages\" : [ \"English\", \"English\" ],\n  \"parentSeriesId\" : 6,\n  \"coverImage\" : \"coverImage\",\n  \"directors\" : [ {\n    \"name\" : \"name\",\n    \"id\" : 2,\n    \"biography\" : \"biography\",\n    \"birthDate\" : \"birthDate\"\n  }, {\n    \"name\" : \"name\",\n    \"id\" : 2,\n    \"biography\" : \"biography\",\n    \"birthDate\" : \"birthDate\"\n  } ],\n  \"genre\" : \"Action\",\n  \"id\" : 0,\n  \"synopsis\" : \"synopsis\",\n  \"type\" : \"movie\",\n  \"title\" : \"title\",\n  \"releaseYear\" : 1\n}, {\n  \"duration\" : 5,\n  \"actors\" : [ {\n    \"name\" : \"name\",\n    \"id\" : 5,\n    \"biography\" : \"biography\",\n    \"birthDate\" : \"birthDate\"\n  }, {\n    \"name\" : \"name\",\n    \"id\" : 5,\n    \"biography\" : \"biography\",\n    \"birthDate\" : \"birthDate\"\n  } ],\n  \"languages\" : [ \"English\", \"English\" ],\n  \"parentSeriesId\" : 6,\n  \"coverImage\" : \"coverImage\",\n  \"directors\" : [ {\n    \"name\" : \"name\",\n    \"id\" : 2,\n    \"biography\" : \"biography\",\n    \"birthDate\" : \"birthDate\"\n  }, {\n    \"name\" : \"name\",\n    \"id\" : 2,\n    \"biography\" : \"biography\",\n    \"birthDate\" : \"birthDate\"\n  } ],\n  \"genre\" : \"Action\",\n  \"id\" : 0,\n  \"synopsis\" : \"synopsis\",\n  \"type\" : \"movie\",\n  \"title\" : \"title\",\n  \"releaseYear\" : 1\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Content>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Content>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateContent(@Parameter(in = ParameterIn.PATH, description = "The ID of the content to update", required=true, schema=@Schema()) @PathVariable("contentId") Integer contentId
            ,@Parameter(in = ParameterIn.DEFAULT, description = "The updated content data", required=true, schema=@Schema()) @Valid @RequestBody Content body
    ) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}