package fr.sedona.api.versioning.v1.beer.model.dto;

import fr.sedona.api.versioning.core.hibernate.beer.model.domain.BeerEntity;
import fr.sedona.api.versioning.core.hibernate.beer.model.domain.BreweryEntity;
import fr.sedona.api.versioning.core.hibernate.beer.model.domain.BreweryType;
import fr.sedona.api.versioning.v1.beer.model.mapper.BeerMapperV1;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test suite for BeerMapper
 */
@QuarkusTest
class BeerMapperV1IntegrationTest {

    @Inject
    BeerMapperV1 beerMapperV1;

    @Test
    void beer_toDto_should_map_all_entity_fields() {
        // given
        BreweryEntity brewery = new BreweryEntity();
        brewery.id = 1L;
        brewery.setName("Kronenbourg");
        brewery.setType(BreweryType.INDUSTRIAL);
        BeerEntity entity = new BeerEntity();
        entity.setName("name");
        entity.setIngredients(List.of("Eau", "Malt", "Houblon"));
        entity.setAlcoholLevel(5.8f);
        entity.setBrewery(brewery);

        // when
        BeerDtoV1 dto = beerMapperV1.toDto(entity);

        // then
        assertEquals("v1", dto.getVersion());
        assertEquals(entity.getName(), dto.getName());
        assertEquals(entity.getAlcoholLevel(), dto.getAlcoholLevel());
        assertEquals("v1", dto.getBrewery().getVersion());
        assertEquals(brewery.id, dto.getBrewery().getId());
        assertEquals(brewery.getName(), dto.getBrewery().getName());
        assertEquals(brewery.getType(), dto.getBrewery().getType());
    }
}
