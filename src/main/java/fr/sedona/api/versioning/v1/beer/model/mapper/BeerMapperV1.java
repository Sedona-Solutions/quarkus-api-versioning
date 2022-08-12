package fr.sedona.api.versioning.v1.beer.model.mapper;

import fr.sedona.api.versioning.core.hibernate.beer.model.domain.BeerEntity;
import fr.sedona.api.versioning.core.mapper.QuarkusMapperConfig;
import fr.sedona.api.versioning.core.mapper.VersionMapperInterface;
import fr.sedona.api.versioning.v1.beer.model.dto.BeerDtoV1;
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
