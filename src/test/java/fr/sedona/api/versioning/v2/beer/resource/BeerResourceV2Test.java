package fr.sedona.api.versioning.v2.beer.resource;

import fr.sedona.api.versioning.constant.ApiConstant;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class BeerResourceV2Test {

    @Test
    void testGet() {
        given()
                .when().get(ApiConstant.API_URI_BEERS_V2 + "/1")
                .then()
                .statusCode(200)
                .body("id", is(1))
                .body("name", is("1664"))
                .body("brewery.id", is(1))
                .body("brewery.name", is("Kronenbourg"));
    }

    @Test
    void testGetAll() {
        given()
                .when().get(ApiConstant.API_URI_BEERS_V2)
                .then()
                .statusCode(200)
                .body("size()", is(11));
    }

    @Test
    void testSearchByName() {
        given()
                .when().get(ApiConstant.API_URI_BEERS_V2 + "/search/Elephant 1959")
                .then()
                .statusCode(200)
                .body("size()", is(1))
                .body("[0].name", is("Elephant 1959"));
    }
}
