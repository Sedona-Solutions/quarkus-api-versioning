package fr.sedona.versioning.beer.api.v2.model.mapper;

import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BeerEntity;
import fr.sedona.versioning.beer.core.mapper.QuarkusMapperConfig;
import fr.sedona.versioning.beer.core.mapper.VersionMapperInterface;
import fr.sedona.versioning.beer.api.v2.model.dto.BeerDtoV2;
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
