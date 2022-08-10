package fr.sedona.api.versioning.v2.beer.resource;

import fr.sedona.api.versioning.constant.ApiConstant;
import fr.sedona.api.versioning.core.constant.ApiVersionEnum;
import fr.sedona.api.versioning.core.filter.ApiVersionInterceptor;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class BreweryResourceV2IntegrationTest {

    @Test
    void search_should_return_breweries_with_input_matching_name() {
        given()
                .queryParam(ApiVersionInterceptor.QUERY_PARAM_API_VERSION, ApiVersionEnum.V2.getVersion())
                .when()
                .get(ApiConstant.API_URI_BREWERIES + "/1")
                .then()
                .statusCode(200)
                .body("id", is(1))
                .body("version", is("v2"))
                .body("name", is("Kronenbourg"));
    }
}
