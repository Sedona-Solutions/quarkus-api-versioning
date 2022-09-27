package fr.sedona.client.beer.v1.resource;

import fr.sedona.client.beer.v1.model.BreweryClientDTOV1;
import fr.sedona.client.beer.v1.service.BreweryRestClientServiceV1;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Resource for breweries client
 */
@Path("/client/breweries")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Breweries client")
public class BreweryRestClientResourceV1 {

    private final BreweryRestClientServiceV1 breweryRestClientService;

    @Inject
    public BreweryRestClientResourceV1(@RestClient BreweryRestClientServiceV1 breweryRestClientService) {
        this.breweryRestClientService = breweryRestClientService;
    }

    @GET
    @Operation(summary = "Get all breweries")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Successfully retrieve breweries",
                    content = @Content(schema = @Schema(type = SchemaType.ARRAY, implementation = BreweryClientDTOV1.class)))
    })
    public Response getBeers() {
        return Response.ok(
                this.breweryRestClientService.getAllBreweries()
        ).build();
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Get a brewery by id")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Successfully retrieve brewery",
                    content = @Content(schema = @Schema(implementation = BreweryClientDTOV1.class))),
            @APIResponse(responseCode = "404", description = "Resource brewery not found")
    })
    public Response getBrewery(@PathParam("id") long id) {
        return Response.ok(
                this.breweryRestClientService.getBrewery(id)
        ).build();
    }

    @POST
    @Operation(summary = "Create a brewery")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Brewery successfully created",
                    content = @Content(schema = @Schema(implementation = BreweryClientDTOV1.class)))
    })
    public Response createBrewery(@RequestBody BreweryClientDTOV1 breweryDTO) {
        return breweryRestClientService.createBrewery(breweryDTO);
    }

    @PATCH
    @Path("{id}")
    @Operation(summary = "Update brewery name")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Brewery name successfully updated",
                    content = @Content(schema = @Schema(implementation = BreweryClientDTOV1.class))),
            @APIResponse(responseCode = "404", description = "Resource brewery not found")
    })
    public Response updateBreweryName(@PathParam("id") Long id, @RequestBody String name) {
        return breweryRestClientService.updateBreweryName(id, name);
    }

    @PUT
    @Path("{id}")
    @Operation(summary = "Update brewery")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Brewery successfully updated",
                    content = @Content(schema = @Schema(implementation = BreweryClientDTOV1.class))),
            @APIResponse(responseCode = "404", description = "Resource brewery not found")
    })
    public Response updateBrewery(@PathParam("id") Long id, @RequestBody BreweryClientDTOV1 breweryDTO) {
        return breweryRestClientService.updateBrewery(id, breweryDTO);
    }

    @DELETE
    @Path("{id}")
    @Transactional
    @Operation(summary = "Delete brewery")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Brewery successfully deleted",
                    content = @Content(schema = @Schema(implementation = BreweryClientDTOV1.class))),
            @APIResponse(responseCode = "404", description = "Resource brewery not found")
    })
    public Response deleteBrewery(@PathParam("id") Long id) {
        return breweryRestClientService.deleteBrewery(id);
    }
}