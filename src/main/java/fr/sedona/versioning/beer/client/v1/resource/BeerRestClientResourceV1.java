package fr.sedona.versioning.beer.client.v1.resource;

import fr.sedona.versioning.beer.client.v1.model.BeerClientDTOV1;
import fr.sedona.versioning.beer.client.v1.service.BeerRestClientServiceV1;
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
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Resource for beers client
 */
@Path("/v1/client/beers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Beers client V1")
public class BeerRestClientResourceV1 {

    private final BeerRestClientServiceV1 beerRestClientService;

    @Inject
    public BeerRestClientResourceV1(@RestClient BeerRestClientServiceV1 beerRestClientService) {
        this.beerRestClientService = beerRestClientService;
    }

    @GET
    @Operation(summary = "Get all beers")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Successfully retrieve beers",
                    content = @Content(schema = @Schema(type = SchemaType.ARRAY, implementation = BeerClientDTOV1.class)))
    })
    public Response getBeers() {
        return Response.ok(
                this.beerRestClientService.getAllBeers()
        ).build();
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Get a beer by id")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Successfully retrieve beer",
                    content = @Content(schema = @Schema(implementation = BeerClientDTOV1.class))),
            @APIResponse(responseCode = "404", description = "Resource beer not found")
    })
    public Response getBeer(@PathParam("id") long id) {
        return Response.ok(
                this.beerRestClientService.getBeerByName(id)
        ).build();
    }

    @GET
    @Path("search/{name}")
    @Operation(summary = "Get a beer by name")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Successfully retrieve beer",
                    content = @Content(schema = @Schema(type = SchemaType.ARRAY, implementation = BeerClientDTOV1.class))),
            @APIResponse(responseCode = "404", description = "Resource beer not found")
    })
    public Response getBeer(@PathParam("name") String name) {
        return Response.ok(
                this.beerRestClientService.getBeerByName(name)
        ).build();
    }

    @POST
    @Operation(summary = "Create a beer")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Beer successfully created",
                    content = @Content(schema = @Schema(implementation = BeerClientDTOV1.class)))
    })
    public Response createBeer(@RequestBody BeerClientDTOV1 beerDTO) {
        return beerRestClientService.createBeer(beerDTO);
    }

    @PATCH
    @Path("{id}")
    @Operation(summary = "Update beer name")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Beer name successfully updated",
                    content = @Content(schema = @Schema(implementation = BeerClientDTOV1.class))),
            @APIResponse(responseCode = "404", description = "Resource beer not found")
    })
    public Response updateBeerName(@PathParam("id") Long id, @RequestBody String name) {
        return beerRestClientService.updateBeerName(id, name);
    }

    @PUT
    @Path("{id}")
    @Operation(summary = "Update beer")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Beer successfully updated",
                    content = @Content(schema = @Schema(implementation = BeerClientDTOV1.class))),
            @APIResponse(responseCode = "404", description = "Resource beer not found")
    })
    public Response updateBeer(@PathParam("id") Long id, @RequestBody BeerClientDTOV1 beerClientDTO) {
        return beerRestClientService.updateBeer(id, beerClientDTO);
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete beer")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Beer successfully deleted",
                    content = @Content(schema = @Schema(implementation = BeerClientDTOV1.class))),
            @APIResponse(responseCode = "404", description = "Resource beer not found")
    })
    public Response deleteBeer(@PathParam("id") Long id) {
        return beerRestClientService.deleteBeer(id);
    }
}