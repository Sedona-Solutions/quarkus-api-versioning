package fr.sedona.client.v1.model;

import fr.sedona.api.versioning.core.hibernate.beer.model.domain.BreweryType;
import fr.sedona.api.versioning.core.model.dto.AbstractDto;
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
