package fr.sedona.versioning.beer.api.v1.model.dto;

import fr.sedona.versioning.beer.core.model.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatorDtoV1 extends AbstractDto {
    private Long id;

    private String lastName;

    private String firstName;
}
