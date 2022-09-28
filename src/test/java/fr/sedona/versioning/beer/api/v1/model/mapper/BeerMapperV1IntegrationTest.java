package fr.sedona.versioning.beer.api.v1.model.mapper;

import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BeerEntity;
import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BreweryEntity;
import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BreweryType;
import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.CreatorEntity;
import fr.sedona.versioning.beer.api.v1.model.dto.BeerDtoV1;
import fr.sedona.versioning.beer.api.v1.model.mapper.BeerMapperV1;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

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
        brewery.setId(1L);
        brewery.setName("Kronenbourg");
        brewery.setType(BreweryType.INDUSTRIAL);
        BeerEntity entity = new BeerEntity();
        entity.setName("name");
        entity.setAlcoholLevel(5.8f);
        entity.setBrewery(brewery);
        entity.setCreator(CreatorEntity
                .builder()
                .id(1L)
                .firstName("Edouard")
                .lastName("Lamotte")
                .build());

        // when
        BeerDtoV1 dto = beerMapperV1.toDto(entity);

        // then
        assertEquals(entity.getName(), dto.getName());
        assertEquals(entity.getAlcoholLevel(), dto.getAlcoholLevel());
        assertEquals(entity.getCreator().getId(), dto.getCreatorId());
        assertEquals(brewery.getId(), dto.getBrewery().getId());
        assertEquals(brewery.getName(), dto.getBrewery().getName());
        assertEquals(brewery.getType(), dto.getBrewery().getType());
    }
}
