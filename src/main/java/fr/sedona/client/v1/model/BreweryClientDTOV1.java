package fr.sedona.client.v1.model;

import fr.sedona.api.versioning.core.hibernate.beer.model.domain.BreweryType;
import lombok.Getter;
import lombok.Setter;

/**
 * Brewery DTO
 */
@Getter
@Setter
public class BreweryClientDTOV1 {

    private Long id;
    private String name;
    private BreweryType type;
    private String country;
}
