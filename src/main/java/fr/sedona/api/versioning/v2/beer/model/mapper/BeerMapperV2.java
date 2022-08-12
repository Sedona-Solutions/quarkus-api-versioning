package fr.sedona.api.versioning.v2.beer.model.mapper;

import fr.sedona.api.versioning.core.hibernate.beer.model.domain.BeerEntity;
import fr.sedona.api.versioning.core.mapper.QuarkusMapperConfig;
import fr.sedona.api.versioning.core.mapper.VersionMapperInterface;
import fr.sedona.api.versioning.v2.beer.model.dto.BeerDtoV2;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper interface for Beer/Brewery operations
 */
@Mapper(
        config = QuarkusMapperConfig.class,
        uses = {BreweryMapperV2.class, CreatorMapperV2.class}
)
public interface BeerMapperV2 extends VersionMapperInterface {
    @Mapping(target = "version", constant = versionV2)
    BeerDtoV2 toDto(BeerEntity entity);

    BeerEntity toEntity(BeerDtoV2 dto);
}
