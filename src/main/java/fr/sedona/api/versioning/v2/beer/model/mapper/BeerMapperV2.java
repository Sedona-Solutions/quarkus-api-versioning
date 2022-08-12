package fr.sedona.api.versioning.v2.beer.model.mapper;

import fr.sedona.api.versioning.core.hibernate.beer.model.domain.BeerEntity;
import fr.sedona.api.versioning.core.mapper.QuarkusMapperConfig;
import fr.sedona.api.versioning.core.mapper.VersionMapperInterface;
import fr.sedona.api.versioning.v2.beer.model.dto.BeerDtoV2;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * Mapper interface for Beer operations
 */
@Mapper(
        config = QuarkusMapperConfig.class,
        uses = {BreweryMapperV2.class, CreatorMapperV2.class}
)
public interface BeerMapperV2 extends VersionMapperInterface {
    @Mapping(target = "version", constant = VERSION_V_2)
    BeerDtoV2 toDto(BeerEntity entity);

    BeerEntity toExistingEntity(BeerDtoV2 beerDto, @MappingTarget BeerEntity entity);

    BeerEntity toEntity(BeerDtoV2 dto);
}
