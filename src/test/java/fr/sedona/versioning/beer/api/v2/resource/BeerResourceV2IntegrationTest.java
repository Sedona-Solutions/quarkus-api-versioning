package fr.sedona.versioning.beer.api.v2.resource;

import fr.sedona.versioning.beer.constant.ApiConstant;
import fr.sedona.versioning.beer.core.constant.ApiVersionEnum;
import fr.sedona.versioning.beer.core.filter.ApiVersionInterceptor;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class BeerResourceV2IntegrationTest {

    @Test
    void testGet() {
        given()
                .queryParam(ApiVersionInterceptor.QUERY_PARAM_API_VERSION, ApiVersionEnum.V2.getVersion())
                .when().get(ApiConstant.API_URI_BEERS + "/1")
                .then()
                .statusCode(200)
                .body("version", is("v2"))
                .body("alcoholLevel", is(5.5F))
                .body("id", is(1))
                .body("name", is("1664"))
                .body("ingredients[0]", is("Eau"))
                .body("brewery.version", is("v2"))
                .body("brewery.id", is(1))
                .body("brewery.name", is("Kronenbourg"))
                .body("brewery.type", is("INDUSTRIAL"))
                .body("brewery.country", is("France"))
                .body("creator.version", is("v2"))
                .body("creator.id", is(1))
                .body("creator.lastName", is("Lamotte"))
                .body("creator.firstName", is("Edouard"));
    }

    @Test
    void testGetAll() {
        given()
                .queryParam(ApiVersionInterceptor.QUERY_PARAM_API_VERSION, ApiVersionEnum.V2.getVersion())
                .when().get(ApiConstant.API_URI_BEERS)
                .then()
                .statusCode(200)
                .body("size()", is(11));
    }

    @Test
    void testSearchByName() {
        given()
                .queryParam(ApiVersionInterceptor.QUERY_PARAM_API_VERSION, ApiVersionEnum.V2.getVersion())
                .when().get(ApiConstant.API_URI_BEERS + "/search/Elephant 1959")
                .then()
                .statusCode(200)
                .body("size()", is(1))
                .body("[0].version", is("v2"))
                .body("[0].name", is("Elephant 1959"));
    }
}
