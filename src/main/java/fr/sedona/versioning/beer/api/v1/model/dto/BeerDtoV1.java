package fr.sedona.versioning.beer.api.v1.model.dto;

import fr.sedona.versioning.beer.core.model.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Beer DTO
 */
@Getter
@Setter
public class BeerDtoV1 extends AbstractDto {

    private Long id;
    private String name;
    private float alcoholLevel;
    private BreweryDtoV1 brewery;
    private Long creatorId;

}
