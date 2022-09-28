package fr.sedona.versioning.beer.api.v2.service;

import fr.sedona.versioning.beer.api.v2.model.dto.BeerDtoV2;

import java.util.List;

/**
 * Beer service
 */
public interface BeerServiceV2 {

    BeerDtoV2 findById(long id);

    List<BeerDtoV2> findByName(String nameQuery);

    List<BeerDtoV2> findAll();

    Long createBeer(BeerDtoV2 beerDTO);

    void updateBeer(BeerDtoV2 beerDTO);

    void deleteBeer(long id);

    List<BeerDtoV2> findByCreatorName(String creatorNameQuery);

    List<BeerDtoV2> findByCreatorFirstNameAndLastName(String firstName, String lastName);
}