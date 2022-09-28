package fr.sedona.versioning.beer.client.v2.resource;

import fr.sedona.versioning.beer.constant.ApiConstant;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class BreweryRestClientResourceV2IntegrationTest {

    @Test
    void search_should_return_breweries_with_input_matching_name() {
        given()
                .when()
                .get(ApiConstant.API_URI_BREWERIES_CLIENT_V2 + "/1")
                .then()
                .statusCode(200)
                .body("id", is(1))
                .body("version", is("v2"))
                .body("name", is("Kronenbourg"));
    }
}
