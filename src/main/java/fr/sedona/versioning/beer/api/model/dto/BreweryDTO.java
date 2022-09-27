package fr.sedona.versioning.beer.api.model.dto;

import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BreweryType;
import lombok.Getter;
import lombok.Setter;

/**
 * Brewery DTO
 */
@Getter
@Setter
public class BreweryDTO {

    private Long id;
    private String name;
    private BreweryType type;
    private String country;
}
