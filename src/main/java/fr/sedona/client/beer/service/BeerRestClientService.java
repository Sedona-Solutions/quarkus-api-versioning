package fr.sedona.client.beer.service;

import fr.sedona.client.beer.model.BeerClientDTO;
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
public interface BeerRestClientService {

    @GET
    List<BeerClientDTO> getAllBeers();

    @GET
    @Path("{id}")
    BeerClientDTO getBeerByName(@PathParam("id") long id);

    @GET
    @Path("search/{name}")
    List<BeerClientDTO> getBeerByName(@PathParam("name") String name);

    @POST
    Response createBeer(@RequestBody BeerClientDTO beerClientDTO);

    @PATCH
    @Path("{id}")
    Response updateBeerName(@PathParam("id") Long id, @RequestBody String name);

    @PUT
    @Path("{id}")
    Response updateBeer(@PathParam("id") Long id, @RequestBody BeerClientDTO beerClientDTO);

    @DELETE
    @Path("{id}")
    Response deleteBeer(@PathParam("id") Long id);
}
