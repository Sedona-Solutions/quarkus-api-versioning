package fr.sedona.api.versioning.v1.beer.service;


import fr.sedona.api.versioning.v1.beer.model.dto.BreweryDtoV1;

import java.util.List;

/**
 * Brewery service
 */
public interface BreweryServiceV1 {

    Long createBrewery(BreweryDtoV1 breweryDTO);

    void updateBrewery(BreweryDtoV1 breweryDTO);

    void deleteBrewery(long id);

    BreweryDtoV1 findById(long id);

    List<BreweryDtoV1> findAll();

    List<BreweryDtoV1> findByName(String nameQuery);
}
