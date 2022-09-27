package fr.sedona.client.beer.v2.service;

import fr.sedona.client.beer.v2.model.BreweryClientDTO;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/breweries")
@RegisterRestClient(configKey = "beers-api")
public interface BreweryRestClientService {

    @GET
    List<BreweryClientDTO> getAllBreweries();

    @GET
    @Path("{id}")
    BreweryClientDTO getBrewery(@PathParam("id") long id);

    @POST
    Response createBrewery(@RequestBody BreweryClientDTO breweryDTO);

    @PATCH
    @Path("{id}")
    Response updateBreweryName(@PathParam("id") Long id, @RequestBody String name);

    @PUT
    @Path("{id}")
    Response updateBrewery(@PathParam("id") Long id, @RequestBody BreweryClientDTO breweryDTO);

    @DELETE
    @Path("{id}")
    Response deleteBrewery(@PathParam("id") Long id);
}
