package fr.sedona.client.beer.v2.resource;

import fr.sedona.client.beer.v2.model.BeerClientDTO;
import fr.sedona.client.beer.v2.service.BeerRestClientService;
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
@Path("/client/beers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Beers client")
public class BeerRestClientResource {

    private final BeerRestClientService beerRestClientService;

    @Inject
    public BeerRestClientResource(@RestClient BeerRestClientService beerRestClientService) {
        this.beerRestClientService = beerRestClientService;
    }

    @GET
    @Operation(summary = "Get all beers")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Successfully retrieve beers",
                    content = @Content(schema = @Schema(type = SchemaType.ARRAY, implementation = BeerClientDTO.class)))
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
                    content = @Content(schema = @Schema(implementation = BeerClientDTO.class))),
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
                    content = @Content(schema = @Schema(type = SchemaType.ARRAY, implementation = BeerClientDTO.class))),
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
                    content = @Content(schema = @Schema(implementation = BeerClientDTO.class)))
    })
    public Response createBeer(@RequestBody BeerClientDTO beerDTO) {
        return beerRestClientService.createBeer(beerDTO);
    }

    @PATCH
    @Path("{id}")
    @Operation(summary = "Update beer name")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Beer name successfully updated",
                    content = @Content(schema = @Schema(implementation = BeerClientDTO.class))),
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
                    content = @Content(schema = @Schema(implementation = fr.sedona.api.versioning.beer.model.dto.BeerDTO.class))),
            @APIResponse(responseCode = "404", description = "Resource beer not found")
    })
    public Response updateBeer(@PathParam("id") Long id, @RequestBody BeerClientDTO beerClientDTO) {
        return beerRestClientService.updateBeer(id, beerClientDTO);
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete beer")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Beer successfully deleted",
                    content = @Content(schema = @Schema(implementation = BeerClientDTO.class))),
            @APIResponse(responseCode = "404", description = "Resource beer not found")
    })
    public Response deleteBeer(@PathParam("id") Long id) {
        return beerRestClientService.deleteBeer(id);
    }
}