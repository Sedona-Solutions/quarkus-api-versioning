package fr.sedona.api.versioning.v1.beer.resource;

import fr.sedona.api.versioning.constant.ApiConstant;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.Header;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class BeerResourceV1IntegrationTest {
    @Test
    void testGet() {
        given()
                .header(new Header(ApiConstant.HEADER_ACCEPT, ApiConstant.API_HEADER_V1))
                .when().get(ApiConstant.API_URI_BEERS + "/1")
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
                .header(new Header(ApiConstant.HEADER_ACCEPT, ApiConstant.API_HEADER_V1))
                .when().get(ApiConstant.API_URI_BEERS)
                .then()
                .statusCode(200)
                .body("size()", is(11));
    }

    @Test
    void testSearchByName() {
        given()
                .header(new Header(ApiConstant.HEADER_ACCEPT, ApiConstant.API_HEADER_V1))
                .when().get(ApiConstant.API_URI_BEERS + "/search/Elephant 1959")
                .then()
                .statusCode(200)
                .body("size()", is(1))
                .body("[0].version", is("v1"))
                .body("[0].name", is("Elephant 1959"));
    }
}
