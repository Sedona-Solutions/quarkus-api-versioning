package fr.sedona.versioning.beer.core.filter;

import fr.sedona.versioning.beer.core.constant.ApiVersionEnum;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import java.io.UnsupportedEncodingException;
import java.net.URI;

@Provider
@PreMatching
public class ApiVersionInterceptor implements ContainerRequestFilter {

    public static final String QUERY_PARAM_API_VERSION = "version";

    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void filter(ContainerRequestContext context) throws UnsupportedEncodingException {
        var apiVersion = ApiVersionEnum.getEnum(
                context.getUriInfo().getQueryParameters().getFirst(QUERY_PARAM_API_VERSION)
        );

        context.setRequestUri(
                URI.create(
                        apiVersion.getVersion() + context.getUriInfo().getPath().replace(" ", "%20")
                )
        );
    }
}
