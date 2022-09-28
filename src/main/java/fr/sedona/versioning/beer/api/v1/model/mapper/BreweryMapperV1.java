package fr.sedona.versioning.beer.api.v1.model.mapper;

import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BreweryEntity;
import fr.sedona.versioning.beer.core.mapper.QuarkusMapperConfig;
import fr.sedona.versioning.beer.core.mapper.VersionMapperInterface;
import fr.sedona.versioning.beer.api.v1.model.dto.BreweryDtoV1;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * Mapper interface for Brewery operations
 */
@Mapper(
        config = QuarkusMapperConfig.class,
        uses = BeerMapperV1.class
)
public interface BreweryMapperV1 extends VersionMapperInterface {
    @Mapping(target = "version", constant = VERSION_V_1)
    BreweryDtoV1 toDto(BreweryEntity entity);

    BreweryEntity toExistingEntity(BreweryDtoV1 breweryDto, @MappingTarget BreweryEntity entity);

    BreweryEntity toEntity(BreweryDtoV1 dto);
}