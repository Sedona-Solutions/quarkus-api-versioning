package fr.sedona.versioning.beer.api.v1.resource;

import fr.sedona.versioning.beer.api.v1.model.dto.BeerDtoV1;
import fr.sedona.versioning.beer.api.v1.service.BeerServiceV1;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * Resource for beers
 */
@Path("/v1/beers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Beers V1")
public class BeerResourceV1 {

    private final BeerServiceV1 beerService;

    @Inject
    public BeerResourceV1(BeerServiceV1 beerService) {
        this.beerService = beerService;
    }

    @GET
    @Operation(summary = "Get all beers")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Successfully retrieve beers",
                    content = @Content(schema = @Schema(type = SchemaType.ARRAY, implementation = BeerDtoV1.class)))
    })
    public Response getBeers() {
        return Response.ok(
                this.beerService.findAll()
        ).build();
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Get a beer by id")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Successfully retrieve beer",
                    content = @Content(schema = @Schema(implementation = BeerDtoV1.class))),
            @APIResponse(responseCode = "404", description = "Resource beer not found")
    })
    public Response getBeer(@PathParam("id") long id) {
        return Response.ok(
                this.beerService.findById(id)
        ).build();
    }

    @GET
    @Path("search/{name}")
    @Operation(summary = "Get a beer by name")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Successfully retrieve beer",
                    content = @Content(schema = @Schema(type = SchemaType.ARRAY, implementation = BeerDtoV1.class))),
            @APIResponse(responseCode = "404", description = "Resource beer not found")
    })
    public Response getBeer(@PathParam("name") String name) {
        return Response.ok(
                this.beerService.findByName(name)
        ).build();
    }

    @POST
    @Operation(summary = "Create a beer")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Beer successfully created",
                    content = @Content(schema = @Schema(implementation = BeerDtoV1.class)))
    })
    public Response createBeer(@RequestBody BeerDtoV1 beerDTO) {
        var id = beerService.createBeer(beerDTO);
        return Response.created(URI.create("/beers/" + id)).build();
    }

    @PATCH
    @Path("{id}")
    @Operation(summary = "Update beer name")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Beer name successfully updated",
                    content = @Content(schema = @Schema(implementation = BeerDtoV1.class))),
            @APIResponse(responseCode = "404", description = "Resource beer not found")
    })
    public Response updateBeerName(@PathParam("id") Long id, @RequestBody String name) {
        BeerDtoV1 beer = beerService.findById(id);
        beer.setName(name);
        beerService.updateBeer(beer);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    @Operation(summary = "Update beer")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Beer successfully updated",
                    content = @Content(schema = @Schema(implementation = BeerDtoV1.class))),
            @APIResponse(responseCode = "404", description = "Resource beer not found")
    })
    public Response updateBeer(@PathParam("id") Long id, @RequestBody BeerDtoV1 beerDTO) {
        beerService.updateBeer(beerDTO);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete beer")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Beer successfully deleted",
                    content = @Content(schema = @Schema(implementation = BeerDtoV1.class))),
            @APIResponse(responseCode = "404", description = "Resource beer not found")
    })
    public Response deleteBeer(@PathParam("id") Long id) {
        beerService.deleteBeer(id);
        return Response.noContent().build();
    }
}
