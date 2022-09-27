package fr.sedona.versioning.beer.api.service;


import fr.sedona.versioning.beer.api.model.dto.BreweryDTO;

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
