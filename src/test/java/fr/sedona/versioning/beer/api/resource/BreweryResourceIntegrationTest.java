package fr.sedona.versioning.beer.api.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class BreweryResourceIntegrationTest {

    @Test
    void autocomplete_should_return_breweries_starting_with_input() {
        given()
                .when()
                .get("/api/breweries/1")
                .then()
                .statusCode(200)
                .body("id", is(1))
                .body("name", is("Kronenbourg"));
    }
}
