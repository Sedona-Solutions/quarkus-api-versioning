package fr.sedona.versioning.beer.client.v1.model;

import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BreweryType;
import fr.sedona.versioning.beer.core.model.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Brewery DTO client  V1
 */
@Getter
@Setter
public class BreweryClientDTOV1 extends AbstractDto {

    private Long id;
    private String name;
    private BreweryType type;
    private String country;
}
