package fr.sedona.versioning.beer.api.v2.resource;

import fr.sedona.versioning.beer.constant.ApiConstant;
import fr.sedona.versioning.beer.core.constant.ApiVersionEnum;
import fr.sedona.versioning.beer.core.filter.ApiVersionInterceptor;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.Header;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class BreweryResourceV2Test {

    @Test
    void autocomplete_should_return_breweries_starting_with_input() {
        given()
                .header(new Header(ApiVersionInterceptor.HEADER_X_API_VERSION, ApiVersionEnum.V2.getVersion()))
                .when()
                .get(ApiConstant.API_URI_BREWERIES + "/1")
                .then()
                .statusCode(200)
                .body("id", is(1))
                .body("name", is("Kronenbourg"));
    }
}
