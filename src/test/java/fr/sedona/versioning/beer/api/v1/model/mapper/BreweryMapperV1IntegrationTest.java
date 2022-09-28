package fr.sedona.versioning.beer.api.v1.model.mapper;

import fr.sedona.versioning.beer.api.v1.model.mapper.BreweryMapperV1;
import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BeerEntity;
import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BreweryEntity;
import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BreweryType;
import fr.sedona.versioning.beer.api.v1.model.dto.BreweryDtoV1;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test suite for BeerMapper
 */
@QuarkusTest
class BreweryMapperV1IntegrationTest {

    @Inject
    BreweryMapperV1 breweryMapperV1;

    @Test
    void beer_toDto_should_map_all_entity_fields() {
        // given
        BreweryEntity brewery = new BreweryEntity();
        brewery.setId(1L);
        brewery.setName("Kronenbourg");
        brewery.setType(BreweryType.INDUSTRIAL);
        BeerEntity beerentity = new BeerEntity();
        beerentity.setName("name");
        beerentity.setIngredients(List.of("Eau", "Malt", "Houblon"));
        beerentity.setAlcoholLevel(5.8f);
        brewery.setBeers(List.of(beerentity));

        // when
        BreweryDtoV1 dto = breweryMapperV1.toDto(brewery);

        // then
        assertEquals("v1", dto.getVersion());
        assertEquals(brewery.getId(), dto.getId());
        assertEquals(brewery.getName(), dto.getName());
        assertEquals(brewery.getType(), dto.getType());
    }
}
