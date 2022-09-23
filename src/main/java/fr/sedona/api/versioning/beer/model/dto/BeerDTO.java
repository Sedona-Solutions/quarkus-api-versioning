package fr.sedona.api.versioning.beer.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Beer DTO
 */
@Getter
@Setter
public class BeerDTO {

    private Long id;
    private String name;
    private float alcoholLevel;
    private BreweryDTO brewery;
    private Long creatorId;

}
