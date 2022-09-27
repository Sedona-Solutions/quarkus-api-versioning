package fr.sedona.client.v1.model;

import fr.sedona.api.versioning.core.model.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatorClientDTOV1 extends AbstractDto {
    private Long id;
    private String lastName;
    private String firstName;
}
