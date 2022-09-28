package fr.sedona.versioning.beer.api.v1.model.mapper;

import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BeerEntity;
import fr.sedona.versioning.beer.core.mapper.QuarkusMapperConfig;
import fr.sedona.versioning.beer.core.mapper.VersionMapperInterface;
import fr.sedona.versioning.beer.api.v1.model.dto.BeerDtoV1;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * Mapper interface for Beer operations
 */
@Mapper(
        config = QuarkusMapperConfig.class,
        uses = BreweryMapperV1.class
)
public interface BeerMapperV1 extends VersionMapperInterface {
    @Mapping(target = "version", constant = VERSION_V_1)
    @Mapping(target = "creatorId", source = "creator.id")
    BeerDtoV1 toDto(BeerEntity entity);

    BeerEntity toExistingEntity(BeerDtoV1 beerDto, @MappingTarget BeerEntity entity);

    BeerEntity toEntity(BeerDtoV1 dto);
}
