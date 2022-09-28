package fr.sedona.versioning.beer.client.v1.service;

import fr.sedona.versioning.beer.client.v1.model.BreweryClientDTOV1;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Produces("application/vnd.company.app-v1+json")
@Consumes("application/vnd.company.app-v1+json")
@Path("/breweries")
@RegisterRestClient(configKey = "beers-api")
public interface BreweryRestClientServiceV1 {

    @GET
    List<BreweryClientDTOV1> getAllBreweries();

    @GET
    @Path("{id}")
    BreweryClientDTOV1 getBrewery(@PathParam("id") long id);

    @POST
    Response createBrewery(@RequestBody BreweryClientDTOV1 breweryDTO);

    @PATCH
    @Path("{id}")
    Response updateBreweryName(@PathParam("id") Long id, @RequestBody String name);

    @PUT
    @Path("{id}")
    Response updateBrewery(@PathParam("id") Long id, @RequestBody BreweryClientDTOV1 breweryDTO);

    @DELETE
    @Path("{id}")
    Response deleteBrewery(@PathParam("id") Long id);
}
