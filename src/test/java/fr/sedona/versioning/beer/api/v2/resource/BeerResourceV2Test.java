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
class BeerResourceV2Test {

    @Test
    void testGet() {
        given()
                .header(new Header(ApiVersionInterceptor.HEADER_X_API_VERSION, ApiVersionEnum.V2.getVersion()))
                .when().get(ApiConstant.API_URI_BEERS + "/1")
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
                .header(new Header(ApiVersionInterceptor.HEADER_X_API_VERSION, ApiVersionEnum.V2.getVersion()))
                .when().get(ApiConstant.API_URI_BEERS)
                .then()
                .statusCode(200)
                .body("size()", is(11));
    }

    @Test
    void testSearchByName() {
        given()
                .header(new Header(ApiVersionInterceptor.HEADER_X_API_VERSION, ApiVersionEnum.V2.getVersion()))
                .when().get(ApiConstant.API_URI_BEERS + "/search/Elephant 1959")
                .then()
                .statusCode(200)
                .body("size()", is(1))
                .body("[0].name", is("Elephant 1959"));
    }
}
