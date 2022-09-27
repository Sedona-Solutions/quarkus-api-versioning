package fr.sedona.versioning.beer.api.model.mapper;

import fr.sedona.versioning.beer.api.model.dto.BeerDTO;
import fr.sedona.versioning.beer.api.model.mapper.BeerMapper;
import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BeerEntity;
import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BreweryEntity;
import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BreweryType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test suite for BeerMapper
 */
class BeerMapperTest {

    BeerMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = Mappers.getMapper(BeerMapper.class);
    }

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
        entity.setCreatorId(1L);

        // when
        BeerDTO dto = mapper.toDto(entity);

        // then
        assertEquals(entity.getName(), dto.getName());
        assertEquals(entity.getAlcoholLevel(), dto.getAlcoholLevel());
        assertEquals(entity.getCreatorId(), dto.getCreatorId());
        assertEquals(brewery.getId(), dto.getBrewery().getId());
        assertEquals(brewery.getName(), dto.getBrewery().getName());
        assertEquals(brewery.getType(), dto.getBrewery().getType());
    }
}
