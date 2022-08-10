package fr.sedona.api.versioning.v1.beer.resource;

import fr.sedona.api.versioning.v1.beer.model.dto.BreweryDtoV1;
import fr.sedona.api.versioning.v1.beer.service.BreweryServiceV1;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * Resource for breweries
 */
@Path("/breweries")
@Consumes(MediaType.APPLICATION_JSON)
@Produces("application/vnd.company.app-v1+json")
@Tag(name = "Breweries V1", description = "Manage breweries")
public class BreweryResourceV1 {

    private final BreweryServiceV1 breweryService;

    @Inject
    public BreweryResourceV1(BreweryServiceV1 breweryService) {
        this.breweryService = breweryService;
    }

    @GET
    @Operation(summary = "Get all breweries")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Successfully retrieve breweries",
                    content = @Content(schema = @Schema(type = SchemaType.ARRAY, implementation = BreweryDtoV1.class)))
    })
    public Response getBreweries() {
        return Response.ok(
                this.breweryService.findAll()
        ).build();
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Get a brewery by id")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Successfully retrieve brewery",
                    content = @Content(schema = @Schema(implementation = BreweryDtoV1.class))),
            @APIResponse(responseCode = "404", description = "Resource brewery not found")
    })
    public Response getBrewery(@PathParam("id") long id) {
        return Response.ok(
                this.breweryService.findById(id)
        ).build();
    }

    @POST
    @Operation(summary = "Create a brewery")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Brewery successfully created",
                    content = @Content(schema = @Schema(implementation = BreweryDtoV1.class)))
    })
    public Response createBrewery(@RequestBody BreweryDtoV1 breweryDTO) {
        var id = breweryService.createBrewery(breweryDTO);
        return Response.created(URI.create("/breweries/" + id)).build();
    }

    @PATCH
    @Path("{id}")
    @Operation(summary = "Update brewery name")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Brewery name successfully updated",
                    content = @Content(schema = @Schema(implementation = BreweryDtoV1.class))),
            @APIResponse(responseCode = "404", description = "Resource brewery not found")
    })
    public Response updateBreweryName(@PathParam("id") Long id, @RequestBody String name) {
        BreweryDtoV1 brewery = breweryService.findById(id);
        brewery.setName(name);
        breweryService.updateBrewery(brewery);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    @Operation(summary = "Update brewery")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Brewery successfully updated",
                    content = @Content(schema = @Schema(implementation = BreweryDtoV1.class))),
            @APIResponse(responseCode = "404", description = "Resource brewery not found")
    })
    public Response updateBrewery(@PathParam("id") Long id, @RequestBody BreweryDtoV1 breweryDTO) {
        breweryService.updateBrewery(breweryDTO);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    @Operation(summary = "Delete brewery")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Brewery successfully deleted",
                    content = @Content(schema = @Schema(implementation = BreweryDtoV1.class))),
            @APIResponse(responseCode = "404", description = "Resource brewery not found")
    })
    public Response deleteBrewery(@PathParam("id") Long id) {
        breweryService.deleteBrewery(id);
        return Response.noContent().build();
    }
}
