package fr.sedona.api.versioning.beer.service;


import fr.sedona.api.versioning.beer.model.dto.BreweryDTO;

import java.util.List;

/**
 * Brewery service
 */
public interface BreweryService {

    BreweryDTO createBrewery(BreweryDTO breweryDTO);

    void updateBrewery(BreweryDTO breweryDTO);

    void deleteBrewery(long id);

    BreweryDTO findById(long id);

    List<BreweryDTO> findAll();

    List<BreweryDTO> findByName(String nameQuery);
}
