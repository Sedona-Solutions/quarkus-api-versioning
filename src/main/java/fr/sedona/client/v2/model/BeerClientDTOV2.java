package fr.sedona.client.v2.model;

import fr.sedona.api.versioning.core.model.dto.AbstractDto;
import fr.sedona.api.versioning.v2.beer.model.dto.BreweryDtoV2;
import fr.sedona.api.versioning.v2.beer.model.dto.CreatorDtoV2;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Beer DTO client  V2
 */
@Getter
@Setter
public class BeerClientDTOV2 extends AbstractDto {

    private Long id;
    private String name;
    private float alcoholLevel;
    private List<String> ingredients;
    private BreweryClientDTOV2 brewery;
    private CreatorClientDTOV2 creator;

}
