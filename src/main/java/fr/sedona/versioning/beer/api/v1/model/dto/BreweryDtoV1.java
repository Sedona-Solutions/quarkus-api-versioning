package fr.sedona.versioning.beer.api.v1.model.dto;

import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BreweryType;
import fr.sedona.versioning.beer.core.model.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Brewery DTO
 */
@Getter
@Setter
public class BreweryDtoV1 extends AbstractDto {

    private Long id;
    private String name;
    private BreweryType type;
    private String country;
}