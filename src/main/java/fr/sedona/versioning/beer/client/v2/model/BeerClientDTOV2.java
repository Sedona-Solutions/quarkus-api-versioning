package fr.sedona.versioning.beer.client.v2.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Beer DTO
 */
@Getter
@Setter
public class BeerClientDTOV2 {

    private Long id;
    private String name;
    private float alcoholLevel;
    private BreweryClientDTOV2 brewery;
    private Long creatorId;

}
