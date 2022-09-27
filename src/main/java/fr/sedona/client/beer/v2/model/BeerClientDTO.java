package fr.sedona.client.beer.v2.model;

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
