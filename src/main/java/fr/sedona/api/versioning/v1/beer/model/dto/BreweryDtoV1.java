package fr.sedona.api.versioning.v1.beer.model.dto;

import fr.sedona.api.versioning.core.hibernate.beer.model.domain.BreweryType;
import fr.sedona.api.versioning.core.model.dto.abstractDto.AbstractDto;
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
