package fr.sedona.versioning.beer.api.v2.model.dto;

import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BreweryType;
import fr.sedona.versioning.beer.core.model.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Brewery DTO V2
 */
@Getter
@Setter
public class BreweryDtoV2 extends AbstractDto {

    private Long id;
    private String name;
    private BreweryType type;
    private String country;
}
