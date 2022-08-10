package fr.sedona.api.versioning.v2.beer.resource;

import fr.sedona.api.versioning.beer.model.dto.BeerDTO;
import fr.sedona.api.versioning.beer.service.BeerService;
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
@Path("/beers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces("application/vnd.company.app-v2+json")
@Tag(name = "Beers V2", description = "Manage beers")
public class BeerResourceV2 {

    private final BeerService beerService;

    @Inject
    public BeerResourceV2(BeerService beerService) {
        this.beerService = beerService;
    }

    @GET
    @Operation(summary = "Get all beers")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Successfully retrieve beers",
                    content = @Content(schema = @Schema(type = SchemaType.ARRAY, implementation = BeerDTO.class)))
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
                    content = @Content(schema = @Schema(implementation = BeerDTO.class))),
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
                    content = @Content(schema = @Schema(type = SchemaType.ARRAY, implementation = BeerDTO.class))),
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
                    content = @Content(schema = @Schema(implementation = BeerDTO.class)))
    })
    public Response createBeer(@RequestBody BeerDTO beerDTO) {
        var beerDto = beerService.createBeer(beerDTO);
        return Response.created(URI.create("/beers/" + beerDto.getId())).build();
    }

    @PATCH
    @Path("{id}")
    @Operation(summary = "Update beer name")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Beer name successfully updated",
                    content = @Content(schema = @Schema(implementation = BeerDTO.class))),
            @APIResponse(responseCode = "404", description = "Resource beer not found")
    })
    public Response updateBeerName(@PathParam("id") Long id, @RequestBody String name) {
        BeerDTO beer = beerService.findById(id);
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
                    content = @Content(schema = @Schema(implementation = BeerDTO.class))),
            @APIResponse(responseCode = "404", description = "Resource beer not found")
    })
    public Response updateBeer(@PathParam("id") Long id, @RequestBody BeerDTO beerDTO) {
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
                    content = @Content(schema = @Schema(implementation = BeerDTO.class))),
            @APIResponse(responseCode = "404", description = "Resource beer not found")
    })
    public Response deleteBeer(@PathParam("id") Long id) {
        beerService.deleteBeer(id);
        return Response.noContent().build();
    }
}
