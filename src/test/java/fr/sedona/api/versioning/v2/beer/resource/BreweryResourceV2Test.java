package fr.sedona.api.versioning.v2.beer.resource;

import fr.sedona.api.versioning.constant.ApiConstant;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class BreweryResourceV2Test {

    @Test
    void search_should_return_breweries_with_input_matching_name() {
        given()
                .when()
                .get(ApiConstant.API_URI_BREWERIES_V2 + "/1")
                .then()
                .statusCode(200)
                .body("id", is(1))
                .body("name", is("Kronenbourg"));
    }
}
