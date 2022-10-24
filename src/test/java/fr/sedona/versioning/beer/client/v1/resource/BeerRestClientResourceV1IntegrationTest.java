package fr.sedona.versioning.beer.client.v1.resource;

import fr.sedona.versioning.beer.constant.ApiConstant;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class BeerRestClientResourceV1IntegrationTest {
    @Test
    void testGet() {
        given()
                .when().get(ApiConstant.API_URI_BEERS_CLIENT_V1 + "/1")
                .then()
                .statusCode(200)
                .body("version", is("v1"))
                .body("alcoholLevel", is(5.5F))
                .body("id", is(1))
                .body("name", is("1664"))
                .body("brewery.version", is("v1"))
                .body("brewery.id", is(1))
                .body("brewery.name", is("Kronenbourg"))
                .body("brewery.type", is("INDUSTRIAL"))
                .body("brewery.country", is("France"));
    }

    @Test
    void testGetAll() {
        given()
                .when().get(ApiConstant.API_URI_BEERS_CLIENT_V1)
                .then()
                .statusCode(200)
                .body("size()", is(11));
    }

    @Test
    void testSearchByName() {
        given()
                .when().get(ApiConstant.API_URI_BEERS_CLIENT_V1 + "/search/Elephant 1959")
                .then()
                .statusCode(200)
                .body("size()", is(1))
                .body("[0].version", is("v1"))
                .body("[0].name", is("Elephant 1959"));
    }
}