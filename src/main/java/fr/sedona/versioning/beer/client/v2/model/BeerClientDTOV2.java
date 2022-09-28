package fr.sedona.versioning.beer.client.v2.model;

import fr.sedona.versioning.beer.core.model.dto.AbstractDto;
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
