package fr.sedona.versioning.beer.api.v1.service.impl;

import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BeerEntity;
import fr.sedona.versioning.beer.core.hibernate.beer.repository.BeerRepository;
import fr.sedona.versioning.beer.core.hibernate.beer.repository.BreweryRepository;
import fr.sedona.versioning.beer.api.v1.model.dto.BeerDtoV1;
import fr.sedona.versioning.beer.api.v1.model.mapper.BeerMapperV1;
import fr.sedona.versioning.beer.api.v1.service.BeerServiceV1;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;

/**
 * V1 implementation of beer service
 */
@ApplicationScoped
public class BeerServiceV1Impl implements BeerServiceV1 {

    public static final String BEER_NOT_FOUND = "No beer found with id '%d'";

    private final BeerRepository beerRepository;

    private final BreweryRepository breweryRepository;

    private final BeerMapperV1 beerMapper;

    @Inject
    public BeerServiceV1Impl(BeerRepository beerRepository,
                             BreweryRepository breweryRepository,
                             BeerMapperV1 beerMapper) {
        this.beerRepository = beerRepository;
        this.breweryRepository = breweryRepository;
        this.beerMapper = beerMapper;
    }

    @Override
    public BeerDtoV1 findById(long id) {
        return beerMapper.toDto(
                findEntityById(id)
        );
    }

    private BeerEntity findEntityById(long id) {
        return this.beerRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(String.format(BEER_NOT_FOUND, id)));
    }

    @Override
    public List<BeerDtoV1> findByName(String name) {
        return this.beerRepository.findByName(name).stream().map(beerMapper::toDto).toList();
    }

    @Override
    @Transactional
    public List<BeerDtoV1> findAll() {
        return this.beerRepository.findAll().stream().map(
                beerMapper::toDto
        ).toList();
    }

    @Override
    @Transactional
    public Long createBeer(BeerDtoV1 beerDTO) {
        var beerEntity = beerMapper.toEntity(beerDTO);
        var brewery = breweryRepository.findById(beerDTO.getBrewery().getId());
        brewery.getBeers().add(beerEntity);
        beerEntity.setBrewery(brewery);
        beerRepository.persist(beerEntity);
        return beerEntity.getId();
    }

    @Override
    @Transactional
    public void updateBeer(BeerDtoV1 beerDTO) {
        var beerEntity = this.findEntityById(beerDTO.getId());
        var breweryEntity = breweryRepository.findById(beerDTO.getBrewery().getId());
        breweryEntity.getBeers().add(beerEntity);
        beerEntity.setBrewery(breweryEntity);
        beerMapper.toExistingEntity(beerDTO, beerEntity);
        beerRepository.persist(beerEntity);
    }

    @Override
    @Transactional
    public void deleteBeer(long id) {
        this.findById(id);
        beerRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<BeerDtoV1> findByCreatorName(String creator) {
        return beerRepository.list("creator.firstName = ?1", creator)
                .stream().map(
                        beerMapper::toDto
                ).toList();
    }

    @Override
    @Transactional
    public List<BeerDtoV1> findByCreatorFirstNameAndLastName(String firstName, String lastName) {
        return beerRepository.list("creator.firstName = ?1 and creator.lastName = ?2",
                        firstName, lastName)
                .stream().map(beerMapper::toDto
                ).toList();
    }
}
