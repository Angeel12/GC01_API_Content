package io.swagger.api;

import io.swagger.model.Content;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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


    @Operation(summary = "Delete content", description = "Delete content by its ID", tags={ "contents" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Content deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Content not found") })
    @RequestMapping(value = "/contents/{contentId}",
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteContent(@Parameter(in = ParameterIn.PATH, description = "The ID of the content to delete", required=true, schema=@Schema()) @PathVariable("contentId") Integer contentId
    );


    @Operation(summary = "Get content details", description = "Get detailed information about a specific content", tags={ "contents" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Content details", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @Schema(implementation = Content.class))),
            @ApiResponse(responseCode = "404", description = "Content not found") })
    @RequestMapping(value = "/contents/{contentId}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<Content> getContentById(@Parameter(in = ParameterIn.PATH, description = "The ID of the content to retrieve", required=true, schema=@Schema()) @PathVariable("contentId") Integer contentId
    );


    @Operation(summary = "Get a list of all contents", description = "Retrieve a list of all contents available on the platform", tags={ "contents" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A list of contents", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Content.class)))) })
    @RequestMapping(value = "/contents",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Content>> getContents();


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

}