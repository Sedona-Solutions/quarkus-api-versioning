package fr.sedona.versioning.beer.api.v2.resource;

import fr.sedona.versioning.beer.constant.ApiConstant;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.Header;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class BreweryResourceV2IntegrationTest {

    @Test
    void search_should_return_breweries_with_input_matching_name() {
        given()
                .header(new Header(ApiConstant.HEADER_ACCEPT, ApiConstant.API_HEADER_V2))
                .when()
                .get(ApiConstant.API_URI_BREWERIES + "/1")
                .then()
                .statusCode(200)
                .body("id", is(1))
                .body("version", is("v2"))
                .body("name", is("Kronenbourg"));
    }
}
