package fr.sedona.api.versioning.core.filter;

import fr.sedona.api.versioning.core.constant.ApiVersionEnum;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.UnsupportedEncodingException;
import java.net.URI;

@Provider
@PreMatching
public class ApiVersionInterceptor implements ContainerRequestFilter {

    public static final String HEADER_X_API_VERSION = "X-API-VERSION";

    @Override
    public void filter(ContainerRequestContext context) throws UnsupportedEncodingException {
        var apiVersion = ApiVersionEnum.getEnum(context.getHeaderString(HEADER_X_API_VERSION));

        context.setRequestUri(
                URI.create(
                        apiVersion.getVersion() + context.getUriInfo().getPath().replace(" ", "%20")
                )
        );
    }
}