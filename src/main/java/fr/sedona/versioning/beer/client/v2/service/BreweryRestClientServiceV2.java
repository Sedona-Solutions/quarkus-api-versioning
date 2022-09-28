package fr.sedona.versioning.beer.client.v2.service;

import fr.sedona.versioning.beer.client.v2.model.BreweryClientDTOV2;
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
public interface BreweryRestClientServiceV2 {

    @GET
    List<BreweryClientDTOV2> getAllBreweries(@QueryParam("version") String version);

    @GET
    @Path("{id}")
    BreweryClientDTOV2 getBrewery(@PathParam("id") long id, @QueryParam("version") String version);

    @POST
    Response createBrewery(@QueryParam("version") String version, @RequestBody BreweryClientDTOV2 breweryDTO);

    @PATCH
    @Path("{id}")
    Response updateBreweryName(@PathParam("id") Long id, @QueryParam("version") String version, @RequestBody String name);

    @PUT
    @Path("{id}")
    Response updateBrewery(@PathParam("id") Long id, @QueryParam("version") String version, @RequestBody BreweryClientDTOV2 breweryDTO);

    @DELETE
    @Path("{id}")
    Response deleteBrewery(@PathParam("id") Long id, @QueryParam("version") String version);
}
