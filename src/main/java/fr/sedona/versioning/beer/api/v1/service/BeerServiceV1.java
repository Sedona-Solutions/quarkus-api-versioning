package fr.sedona.versioning.beer.api.v1.service;

import fr.sedona.versioning.beer.api.v1.model.dto.BeerDtoV1;

import java.util.List;

/**
 * Beer service
 */
public interface BeerServiceV1 {

    BeerDtoV1 findById(long id);

    List<BeerDtoV1> findByName(String nameQuery);

    List<BeerDtoV1> findAll();

    Long createBeer(BeerDtoV1 beerDTO);

    void updateBeer(BeerDtoV1 beerDTO);

    void deleteBeer(long id);

    List<BeerDtoV1> findByCreatorName(String creatorNameQuery);

    List<BeerDtoV1> findByCreatorFirstNameAndLastName(String firstName, String lastName);
}