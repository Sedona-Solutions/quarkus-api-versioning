package fr.sedona.api.versioning.v2.beer.model.mapper;

import fr.sedona.api.versioning.core.hibernate.beer.model.domain.BreweryEntity;
import fr.sedona.api.versioning.core.mapper.QuarkusMapperConfig;
import fr.sedona.api.versioning.core.mapper.VersionMapperInterface;
import fr.sedona.api.versioning.v2.beer.model.dto.BreweryDtoV2;
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
