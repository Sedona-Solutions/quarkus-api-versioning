package fr.sedona.versioning.beer.api.v2.model.mapper;

import fr.sedona.versioning.beer.api.v2.model.dto.CreatorDtoV2;
import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.CreatorEntity;
import fr.sedona.versioning.beer.core.mapper.QuarkusMapperConfig;
import fr.sedona.versioning.beer.core.mapper.VersionMapperInterface;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper interface for Beer/Brewery operations
 */
@Mapper(
        config = QuarkusMapperConfig.class,
        uses = BeerMapperV2.class
)
public interface CreatorMapperV2 extends VersionMapperInterface {
    @Mapping(target = "version", constant = VERSION_V_2)
    CreatorDtoV2 toDto(CreatorEntity entity);

    CreatorEntity toEntity(CreatorDtoV2 dto);
}
