package io.swagger.api;

import io.swagger.model.Content;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-17T11:17:33.178797818Z[GMT]")
@Validated
public interface ContentsApi {

    @Operation(summary = "Add new content", description = "Add new content to the platform", tags={ "contents" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Content added successfully", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @Schema(implementation = Content.class))) })
    @RequestMapping(value = "/contents",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Content> addContent(@Parameter(in = ParameterIn.DEFAULT, description = "The content to add", required=true, schema=@Schema()) @Valid @RequestBody Content body
    );

    @Operation(summary = "Update content", description = "Update information about specific content", tags={ "contents" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Content updated successfully"),
            @ApiResponse(responseCode = "404", description = "Content not found") })
    @RequestMapping(value = "/contents/{contentId}",
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Void> updateContent(@Parameter(in = ParameterIn.PATH, description = "The ID of the content to update", required=true, schema=@Schema()) @PathVariable("contentId") Integer contentId
            , @Parameter(in = ParameterIn.DEFAULT, description = "The updated content data", required=true, schema=@Schema()) @Valid @RequestBody Content body
    );

    @Operation(summary = "Get a list of all contents", description = "Retrieve a list of all contents available on the platform", tags={ "contents" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A list of contents", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Content.class)))) })
    @RequestMapping(value = "/contents",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Content>> getContents();


    @Operation(summary = "Get content details", description = "Get detailed information about a specific content", tags={ "contents" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Content details", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @Schema(implementation = Content.class))),
            @ApiResponse(responseCode = "404", description = "Content not found") })
    @RequestMapping(value = "/contents/{contentId}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<Content> getContentById(@Parameter(in = ParameterIn.PATH, description = "The ID of the content to retrieve", required=true, schema=@Schema()) @PathVariable("contentId") Integer contentId
    );

    @Operation(summary = "Delete content", description = "Delete content by its ID", tags={ "contents" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Content deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Content not found") })
    @RequestMapping(value = "/contents/{contentId}",
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteContent(@Parameter(in = ParameterIn.PATH, description = "The ID of the content to delete", required=true, schema=@Schema()) @PathVariable("contentId") Integer contentId
    );

    @Operation(summary = "Search contents by keyword",
            description = "Search contents using a single keyword that matches title, synopsis, actor names, or director names",
            tags = { "contents" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "List of contents matching the keyword",
                    content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json",
                            schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = Content.class)))
    })
    @RequestMapping(value = "/contents/search",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Content>> searchContents(
            @Parameter(in = ParameterIn.QUERY,
                    description = "Keyword to search across title, synopsis, actor names, or director names",
                    required = true,
                    schema = @io.swagger.v3.oas.annotations.media.Schema(type = "string"))
            @RequestParam String keyword);

    @Operation(summary = "Filter contents by genres", description = "Retrieve contents filtered by one or more genres", tags={ "contents" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A list of contents matching the genres", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Content.class)))),
            @ApiResponse(responseCode = "204", description = "No content found for the specified genres")
    })
    @RequestMapping(value = "/contents/filterByGenres",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Content>> filterContentsByGenres(@Parameter(description = "List of genres to filter by", required = true, schema = @Schema()) @RequestParam List<String> genres);

    @Operation(summary = "Retrieve all available genres", description = "Get a list of all genres available on the platform", tags = { "contents" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A list of all available genres", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "204", description = "No genres found")
    })
    @RequestMapping(value = "/contents/genres",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<String>> getAllGenres();


}