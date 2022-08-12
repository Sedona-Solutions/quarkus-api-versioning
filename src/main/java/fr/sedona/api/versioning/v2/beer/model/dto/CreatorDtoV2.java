package fr.sedona.api.versioning.v2.beer.model.dto;

import fr.sedona.api.versioning.core.model.dto.abstractDto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatorDtoV2 extends AbstractDto {
    private Long id;

    private String lastName;

    private String firstName;
}
