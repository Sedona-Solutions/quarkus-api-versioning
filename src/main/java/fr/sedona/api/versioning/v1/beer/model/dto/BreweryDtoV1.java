package fr.sedona.api.versioning.v1.beer.model.dto;

import fr.sedona.api.versioning.core.hibernate.beer.model.domain.BreweryType;
import fr.sedona.api.versioning.core.model.dto.abstractDto.AbstractDto;

/**
 * Brewery DTO
 */
public class BreweryDtoV1 extends AbstractDto {

    private Long id;
    private String name;
    private BreweryType type;
    private String country;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BreweryType getType() {
        return type;
    }

    public void setType(BreweryType type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
