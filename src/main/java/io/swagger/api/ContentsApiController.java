package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.Content;
import io.swagger.service.ContentService;
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
public class ContentsApiController implements ContentsApi {

    private static final Logger log = LoggerFactory.getLogger(ContentsApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final ContentService contentService;

    @org.springframework.beans.factory.annotation.Autowired
    public ContentsApiController(ObjectMapper objectMapper, HttpServletRequest request, ContentService contentService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.contentService = contentService;
    }

    @Override
    public ResponseEntity<Content> addContent(@Parameter(description = "The content to add", required=true) @Valid @RequestBody Content body) {
        Content savedContent = contentService.saveContent(body);
        return new ResponseEntity<>(savedContent, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateContent(@Parameter(description = "The ID of the content to update", required=true) @PathVariable("contentId") Integer contentId, @Parameter(description = "The updated content data", required=true) @Valid @RequestBody Content body) {
        body.setId(contentId);
        contentService.saveContent(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}