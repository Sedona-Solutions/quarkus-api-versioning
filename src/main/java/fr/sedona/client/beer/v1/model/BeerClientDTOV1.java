package fr.sedona.client.beer.v1.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Beer DTO
 */
@Getter
@Setter
public class BeerClientDTOV1 {

    private Long id;
    private String name;
    private float alcoholLevel;
    private BreweryClientDTOV1 brewery;
    private Long creatorId;

}
