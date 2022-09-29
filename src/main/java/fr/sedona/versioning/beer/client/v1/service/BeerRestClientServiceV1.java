package fr.sedona.versioning.beer.client.v1.service;

import fr.sedona.versioning.beer.client.v1.model.BeerClientDTOV1;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/beers")
@RegisterRestClient(configKey = "beers-api")
public interface BeerRestClientServiceV1 {

    @GET
    List<BeerClientDTOV1> getAllBeers(@QueryParam("version") String version);

    @GET
    @Path("{id}")
    BeerClientDTOV1 getBeerByName(@PathParam("id") long id,
                                  @QueryParam("version") String version);

    @GET
    @Path("search/{name}")
    List<BeerClientDTOV1> getBeerByName(@PathParam("name") String name, @QueryParam("version") String version);

    @POST
    Response createBeer(@QueryParam("version") String version, @RequestBody BeerClientDTOV1 beerClientDTO);

    @PATCH
    @Path("{id}")
    Response updateBeerName(@PathParam("id") Long id, @QueryParam("version") String version, @RequestBody String name);

    @PUT
    @Path("{id}")
    Response updateBeer(@PathParam("id") Long id, @QueryParam("version") String version, @RequestBody BeerClientDTOV1 beerClientDTO);

    @DELETE
    @Path("{id}")
    Response deleteBeer(@PathParam("id") Long id, @QueryParam("version") String version);
}
