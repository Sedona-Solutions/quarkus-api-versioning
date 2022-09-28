package fr.sedona.versioning.beer.api.v1.resource;

import fr.sedona.versioning.beer.constant.ApiConstant;
import fr.sedona.versioning.beer.core.constant.ApiVersionEnum;
import fr.sedona.versioning.beer.core.filter.ApiVersionInterceptor;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class BreweryResourceV1IntegrationTest {

    @Test
    void search_should_return_breweries_with_input_matching_name() {
        given()
                .queryParam(ApiVersionInterceptor.QUERY_PARAM_API_VERSION, ApiVersionEnum.V1.getVersion())
                .when()
                .get(ApiConstant.API_URI_BREWERIES + "/1")
                .then()
                .statusCode(200)
                .body("id", is(1))
                .body("version", is("v1"))
                .body("name", is("Kronenbourg"));
    }
}
