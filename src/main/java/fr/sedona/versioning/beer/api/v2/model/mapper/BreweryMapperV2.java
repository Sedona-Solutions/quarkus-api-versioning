package fr.sedona.versioning.beer.api.v2.model.mapper;

import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BreweryEntity;
import fr.sedona.versioning.beer.core.mapper.QuarkusMapperConfig;
import fr.sedona.versioning.beer.core.mapper.VersionMapperInterface;
import fr.sedona.versioning.beer.api.v2.model.dto.BreweryDtoV2;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * Mapper interface for Beer/Brewery operations
 */
@Mapper(
        config = QuarkusMapperConfig.class,
        uses = BeerMapperV2.class
)
public interface BreweryMapperV2 extends VersionMapperInterface {
    @Mapping(target = "version", constant = VERSION_V_2)
    BreweryDtoV2 toDto(BreweryEntity entity);

    BreweryEntity toExistingEntity(BreweryDtoV2 breweryDto, @MappingTarget BreweryEntity entity);

    BreweryEntity toEntity(BreweryDtoV2 dto);
}