package fr.sedona.versioning.beer.api.service;


import fr.sedona.versioning.beer.api.model.dto.BeerDTO;

import java.util.List;

/**
 * Beer service
 */
public interface BeerService {

    BeerDTO findById(long id);

    List<BeerDTO> findByName(String nameQuery);

    List<BeerDTO> findAll();

    Long createBeer(BeerDTO beerDTO);

    void updateBeer(BeerDTO beerDTO);

    void deleteBeer(long id);

    List<BeerDTO> findByCreatorName(String creatorNameQuery);

    List<BeerDTO> findByCreatorFirstNameAndLastName(String firstName, String lastName);
}
