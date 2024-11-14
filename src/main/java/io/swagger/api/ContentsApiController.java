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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<Content> updateContent(@Parameter(description = "The ID of the content to update", required = true) @PathVariable("contentId") Integer contentId, @Parameter(description = "The updated content data", required = true) @Valid @RequestBody Content body) {
        body.setId(contentId);
        Optional<Content> existingContent = contentService.getContentById(contentId);
        if (existingContent.isPresent()) {
            Content updatedContent = contentService.saveContent(body);
            return ResponseEntity.ok(updatedContent);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public ResponseEntity<List<Content>> getContents() {
        List<Content> contents = contentService.getAllContents();
        return new ResponseEntity<>(contents, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Content> getContentById(@Parameter(description = "The ID of the content to retrieve", required=true) @PathVariable("contentId") Integer contentId) {
        Optional<Content> content = contentService.getContentById(contentId);
        if (content.isPresent()) {
            return ResponseEntity.ok(content.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteContent(@Parameter(description = "The ID of the content to delete", required=true) @PathVariable("contentId") Integer contentId) {
        contentService.deleteContent(contentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<Content>> searchContents(@RequestParam String keyword) {
        List<Content> results = contentService.searchContentByKeyword(keyword);
        return ResponseEntity.ok(results);
    }

    @Override
    public ResponseEntity<List<Content>> filterContentsByGenres(@RequestParam List<String> genres) {
        List<Content> contents = contentService.getContentsByGenres(genres);
        if (contents.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(contents);
    }

    @Override
    public ResponseEntity<List<String>> getAllGenres() {
        List<String> genres = contentService.getAllGenres();
        if (genres.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(genres);
    }



}