package fr.sedona.versioning.beer.client.v2.service;

import fr.sedona.versioning.beer.client.v2.RequestapiVersion2HeaderFactory;
import fr.sedona.versioning.beer.client.v2.model.BeerClientDTOV2;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/beers")
@RegisterRestClient(configKey = "beers-api-v2")
@RegisterClientHeaders(RequestapiVersion2HeaderFactory.class)
public interface BeerRestClientServiceV2 {

    @GET
    List<BeerClientDTOV2> getAllBeers();

    @GET
    @Path("{id}")
    BeerClientDTOV2 getBeerByName(@PathParam("id") long id);

    @GET
    @Path("search/{name}")
    List<BeerClientDTOV2> getBeerByName(@PathParam("name") String name);

    @POST
    Response createBeer(@RequestBody BeerClientDTOV2 beerClientDTO);

    @PATCH
    @Path("{id}")
    Response updateBeerName(@PathParam("id") Long id, @RequestBody String name);

    @PUT
    @Path("{id}")
    Response updateBeer(@PathParam("id") Long id, @RequestBody BeerClientDTOV2 beerClientDTO);

    @DELETE
    @Path("{id}")
    Response deleteBeer(@PathParam("id") Long id);
}
