package fr.sedona.versioning.beer.api.model.mapper;

import fr.sedona.versioning.beer.api.model.dto.BeerDTO;
import fr.sedona.versioning.beer.api.model.dto.BreweryDTO;
import fr.sedona.versioning.beer.api.model.dto.CreatorDTO;
import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BeerEntity;
import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BreweryEntity;
import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.CreatorEntity;
import fr.sedona.versioning.beer.core.mapper.QuarkusMapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * Mapper interface for Beer/Brewery operations
 */
@Mapper(
        config = QuarkusMapperConfig.class
)
public interface BeerMapper {

    BeerEntity toExistingEntity(BeerDTO beerDto, @MappingTarget BeerEntity entity);

    BeerDTO toDto(BeerEntity entity);

    BreweryEntity toExistingEntity(BreweryDTO breweryDto, @MappingTarget BreweryEntity entity);

    BreweryDTO toDto(BreweryEntity entity);

    CreatorDTO toDto(CreatorEntity entity);

    CreatorEntity toEntity(CreatorDTO dto);

    BeerEntity toEntity(BeerDTO dto);

    BreweryEntity toEntity(BreweryDTO dto);
}
