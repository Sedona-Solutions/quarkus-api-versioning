package fr.sedona.client.beer.v1.service;

import fr.sedona.client.beer.v1.model.BeerClientDTOV1;
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
    List<BeerClientDTOV1> getAllBeers();

    @GET
    @Path("{id}")
    BeerClientDTOV1 getBeerByName(@PathParam("id") long id);

    @GET
    @Path("search/{name}")
    List<BeerClientDTOV1> getBeerByName(@PathParam("name") String name);

    @POST
    Response createBeer(@RequestBody BeerClientDTOV1 beerClientDTO);

    @PATCH
    @Path("{id}")
    Response updateBeerName(@PathParam("id") Long id, @RequestBody String name);

    @PUT
    @Path("{id}")
    Response updateBeer(@PathParam("id") Long id, @RequestBody BeerClientDTOV1 beerClientDTO);

    @DELETE
    @Path("{id}")
    Response deleteBeer(@PathParam("id") Long id);
}
