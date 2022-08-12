package fr.sedona.api.versioning.v2.beer.service;

import fr.sedona.api.versioning.v2.beer.model.dto.BreweryDtoV2;

import java.util.List;

/**
 * Brewery service
 */
public interface BreweryServiceV2 {

    Long createBrewery(BreweryDtoV2 breweryDTO);

    void updateBrewery(BreweryDtoV2 breweryDTO);

    void deleteBrewery(long id);

    BreweryDtoV2 findById(long id);

    List<BreweryDtoV2> findAll();

    List<BreweryDtoV2> findByName(String nameQuery);
}
