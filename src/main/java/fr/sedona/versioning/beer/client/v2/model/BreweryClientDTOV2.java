package fr.sedona.versioning.beer.client.v2.model;

import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BreweryType;
import fr.sedona.versioning.beer.core.model.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Brewery DTO client  V2
 */
@Getter
@Setter
public class BreweryClientDTOV2 extends AbstractDto {

    private Long id;
    private String name;
    private BreweryType type;
    private String country;
}
