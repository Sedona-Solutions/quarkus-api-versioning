package fr.sedona.versioning.beer.api.v2.model.dto;

import fr.sedona.versioning.beer.core.model.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Beer DTO
 */
@Getter
@Setter
public class BeerDtoV2 extends AbstractDto {

    private Long id;
    private String name;
    private float alcoholLevel;
    private List<String> ingredients;
    private BreweryDtoV2 brewery;
    private CreatorDtoV2 creator;

}
