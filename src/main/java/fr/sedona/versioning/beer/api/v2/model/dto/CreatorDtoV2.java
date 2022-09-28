package fr.sedona.versioning.beer.api.v2.model.dto;

import fr.sedona.versioning.beer.core.model.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatorDtoV2 extends AbstractDto {
    private Long id;

    private String lastName;

    private String firstName;
}