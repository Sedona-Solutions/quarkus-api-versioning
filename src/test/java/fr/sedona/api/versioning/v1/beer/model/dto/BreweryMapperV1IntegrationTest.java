package fr.sedona.api.versioning.v1.beer.model.dto;

import fr.sedona.api.versioning.core.hibernate.beer.model.domain.BeerEntity;
import fr.sedona.api.versioning.core.hibernate.beer.model.domain.BreweryEntity;
import fr.sedona.api.versioning.core.hibernate.beer.model.domain.BreweryType;
import fr.sedona.api.versioning.v1.beer.model.mapper.BreweryMapperV1;
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
        brewery.id = 1L;
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
        assertEquals(brewery.id, dto.getId());
        assertEquals(brewery.getName(), dto.getName());
        assertEquals(brewery.getType(), dto.getType());
    }
}
