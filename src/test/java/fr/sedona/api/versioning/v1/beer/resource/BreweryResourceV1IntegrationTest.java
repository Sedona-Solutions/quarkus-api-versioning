package fr.sedona.api.versioning.v1.beer.resource;

import fr.sedona.api.versioning.core.constant.ApiVersionEnum;
import fr.sedona.api.versioning.core.filter.ApiVersionInterceptor;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.Header;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class BreweryResourceV1IntegrationTest {

    @Test
    void autocomplete_should_return_breweries_starting_with_input() {
        given()
                .header(new Header(ApiVersionInterceptor.HEADER_X_API_VERSION, ApiVersionEnum.V1.getVersion()))
                .then()
                .statusCode(200)
                .body("id", is(1))
                .body("version", is("v1"))
                .body("name", is("Kronenbourg"));
    }
}
