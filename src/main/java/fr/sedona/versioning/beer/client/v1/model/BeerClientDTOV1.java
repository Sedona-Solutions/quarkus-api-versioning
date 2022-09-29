package fr.sedona.versioning.beer.client.v1.model;

import fr.sedona.versioning.beer.core.model.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Beer DTO client  V1
 */
@Getter
@Setter
public class BeerClientDTOV1 extends AbstractDto {

    private Long id;
    private String name;
    private float alcoholLevel;
    private BreweryClientDTOV1 brewery;
    private Long creatorId;

}
