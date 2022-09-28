package fr.sedona.versioning.beer.api.v2.model.mapper;

import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BeerEntity;
import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BreweryEntity;
import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BreweryType;
import fr.sedona.versioning.beer.api.v2.model.dto.BeerDtoV2;
import fr.sedona.versioning.beer.api.v2.model.mapper.BeerMapperV2;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test suite for BeerMapper
 */
@QuarkusTest
class BeerMapperV2IntegrationTest {

    @Inject
    BeerMapperV2 beerMapperV2;

    @Test
    void beer_toDto_should_map_all_entity_fields() {
        // given
        BreweryEntity brewery = new BreweryEntity();
        brewery.setId(1L);
        brewery.setName("Kronenbourg");
        brewery.setType(BreweryType.INDUSTRIAL);
        BeerEntity entity = new BeerEntity();
        entity.setName("name");
        entity.setIngredients(List.of("Eau", "Malt", "Houblon"));
        entity.setAlcoholLevel(5.8f);
        entity.setBrewery(brewery);

        // when
        BeerDtoV2 dto = beerMapperV2.toDto(entity);

        // then
        assertEquals(entity.getName(), dto.getName());
        assertEquals(entity.getAlcoholLevel(), dto.getAlcoholLevel());
        assertEquals(entity.getIngredients(), dto.getIngredients());
        assertEquals(brewery.getId(), dto.getBrewery().getId());
        assertEquals(brewery.getName(), dto.getBrewery().getName());
        assertEquals(brewery.getType(), dto.getBrewery().getType());
    }
}