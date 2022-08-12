package fr.sedona.api.versioning.v1.beer.model.mapper;

import fr.sedona.api.versioning.core.hibernate.beer.model.domain.BreweryEntity;
import fr.sedona.api.versioning.core.mapper.QuarkusMapperConfig;
import fr.sedona.api.versioning.core.mapper.VersionMapperInterface;
import fr.sedona.api.versioning.v1.beer.model.dto.BreweryDtoV1;
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
