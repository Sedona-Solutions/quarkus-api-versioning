package fr.sedona.api.versioning.v1.beer.model.dto;

import fr.sedona.api.versioning.core.model.dto.AbstractDto;
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
