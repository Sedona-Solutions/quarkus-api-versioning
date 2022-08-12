package fr.sedona.api.versioning.v2.beer.model.dto;

import fr.sedona.api.versioning.core.hibernate.beer.model.domain.BreweryType;
import fr.sedona.api.versioning.core.model.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Brewery DTO
 */
@Getter
@Setter
public class BreweryDtoV2 extends AbstractDto {

    private Long id;
    private String name;
    private BreweryType type;
    private String country;
}