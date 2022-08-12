package fr.sedona.api.versioning.v1.beer.service.impl;

import fr.sedona.api.versioning.core.hibernate.beer.repository.BeerRepository;
import fr.sedona.api.versioning.v1.beer.model.dto.BeerDtoV1;
import fr.sedona.api.versioning.v1.beer.model.mapper.BeerMapperV1;
import fr.sedona.api.versioning.v1.beer.service.BeerServiceV1;

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

    private final BeerMapperV1 beerMapper;

    @Inject
    public BeerServiceV1Impl(BeerRepository beerRepository,
                             BeerMapperV1 beerMapper) {
        this.beerRepository = beerRepository;
        this.beerMapper = beerMapper;
    }

    @Override
    public BeerDtoV1 findById(long id) {
        return beerMapper.toDto(
                this.beerRepository.findByIdOptional(id)
                        .orElseThrow(() -> new NotFoundException(String.format(BEER_NOT_FOUND, id)))
        );
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
    public BeerDtoV1 createBeer(BeerDtoV1 beerDTO) {
        beerRepository.persist(beerMapper.toEntity(beerDTO));
        return beerMapper.toDto(beerMapper.toEntity(beerDTO));
    }

    @Override
    @Transactional
    public void updateBeer(BeerDtoV1 beerDTO) {
        this.findById(beerDTO.getId());
        beerMapper.toEntity(beerDTO);
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
        return beerRepository.list("creator.firstName = ?1", creator).stream().map(
                beerMapper::toDto
        ).toList();
    }

    @Override
    @Transactional
    public List<BeerDtoV1> findByCreatorFirstNameAndLastName(String firstName, String lastName) {
        return beerRepository.list("creator.firstName = ?1 and creator.lastName = ?2", firstName, lastName)
                .stream().map(
                        beerMapper::toDto
                ).toList();
    }
}
