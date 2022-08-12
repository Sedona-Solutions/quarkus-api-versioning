package fr.sedona.api.versioning.beer.service.impl;

import fr.sedona.api.versioning.beer.model.dto.BeerDTO;
import fr.sedona.api.versioning.beer.model.mapper.BeerMapper;
import fr.sedona.api.versioning.beer.service.BeerService;
import fr.sedona.api.versioning.core.hibernate.beer.repository.BeerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;

/**
 * Default implementation of beer service
 */
@ApplicationScoped
public class BeerServiceImpl implements BeerService {

    public static final String BEER_NOT_FOUND = "No beer found with id '%d'";

    private final BeerRepository beerRepository;

    private final BeerMapper beerMapper;

    @Inject
    public BeerServiceImpl(BeerRepository beerRepository,
                           BeerMapper beerMapper) {
        this.beerRepository = beerRepository;
        this.beerMapper = beerMapper;
    }

    @Override
    public BeerDTO findById(long id) {
        return beerMapper.toDto(
                this.beerRepository.findByIdOptional(id)
                        .orElseThrow(() -> new NotFoundException(String.format(BEER_NOT_FOUND, id)))
        );
    }

    @Override
    public List<BeerDTO> findByName(String name) {
        return this.beerRepository.findByName(name).stream().map(beerMapper::toDto).toList();
    }

    @Override
    @Transactional
    public List<BeerDTO> findAll() {
        return this.beerRepository.findAll().stream().map(
                beerMapper::toDto
        ).toList();
    }

    @Override
    @Transactional
    public BeerDTO createBeer(BeerDTO beerDTO) {
        beerRepository.persist(beerMapper.toEntity(beerDTO));
        return beerMapper.toDto(beerMapper.toEntity(beerDTO));
    }

    @Override
    @Transactional
    public void updateBeer(BeerDTO beerDTO) {
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
    public List<BeerDTO> findByCreatorName(String creator) {
        return beerRepository.list("creator.firstName = ?1", creator).stream().map(
                beerMapper::toDto
        ).toList();
    }

    @Override
    @Transactional
    public List<BeerDTO> findByCreatorFirstNameAndLastName(String firstName, String lastName) {
        return beerRepository.list("creator.firstName = ?1 and creator.lastName = ?2", firstName, lastName)
                .stream().map(
                        beerMapper::toDto
                ).toList();
    }
}
