package fr.sedona.versioning.beer.client.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Beer DTO
 */
@Getter
@Setter
public class BeerClientDTO {

    private Long id;
    private String name;
    private float alcoholLevel;
    private BreweryClientDTO brewery;
    private Long creatorId;

}
