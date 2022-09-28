package fr.sedona.versioning.beer.client.v2.model;

import fr.sedona.versioning.beer.core.model.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatorClientDTOV2 extends AbstractDto {
    private Long id;
    private String lastName;
    private String firstName;
}
