package fr.sedona.api.versioning.v2.beer.model.mapper;

import fr.sedona.api.versioning.core.hibernate.beer.model.domain.CreatorEntity;
import fr.sedona.api.versioning.core.mapper.QuarkusMapperConfig;
import fr.sedona.api.versioning.core.mapper.VersionMapperInterface;
import fr.sedona.api.versioning.v2.beer.model.dto.CreatorDtoV2;
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
