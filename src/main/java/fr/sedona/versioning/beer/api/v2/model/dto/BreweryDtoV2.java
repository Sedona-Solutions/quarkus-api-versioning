package fr.sedona.versioning.beer.api.v2.model.dto;

import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BreweryType;
import fr.sedona.versioning.beer.core.model.dto.AbstractDto;

/**
 * Brewery DTO
 */
public class BreweryDtoV2 extends AbstractDto {

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
