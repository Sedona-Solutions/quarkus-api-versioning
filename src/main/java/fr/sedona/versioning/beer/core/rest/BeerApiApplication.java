package fr.sedona.versioning.beer.core.rest;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationScoped
@ApplicationPath("/api")
@OpenAPIDefinition(
        tags = {
                @Tag(name = "Beers V1", description = "Manage beers V1"),
                @Tag(name = "Breweries V1", description = "Manage breweries V1"),
                @Tag(name = "Beers client V1", description = "Manage beers with rest client V1"),
                @Tag(name = "Beers V2", description = "Manage beers V2"),
                @Tag(name = "Breweries V2", description = "Manage breweries V2"),
                @Tag(name = "Beers client V2", description = "Manage beers with rest client V2"),

        },
        info = @Info(
                title = "Beer API",
                version = "1.0.0-SNAPSHOT",
                contact = @Contact(
                        name = "Beer API Support",
                        email = "elamotte@sedona.fr"),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"))
)
public class BeerApiApplication extends Application {
}
