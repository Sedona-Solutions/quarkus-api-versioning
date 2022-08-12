package fr.sedona.api.versioning.beer.service.impl;

import fr.sedona.api.versioning.beer.model.dto.BeerDTO;
import fr.sedona.api.versioning.beer.model.mapper.BeerMapper;
import fr.sedona.api.versioning.beer.service.BeerService;
import fr.sedona.api.versioning.core.hibernate.beer.model.domain.BeerEntity;
import fr.sedona.api.versioning.core.hibernate.beer.repository.BeerRepository;
import fr.sedona.api.versioning.core.hibernate.beer.repository.BreweryRepository;

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

    private final BreweryRepository breweryRepository;

    private final BeerMapper beerMapper;

    @Inject
    public BeerServiceImpl(BeerRepository beerRepository,
                           BreweryRepository breweryRepository,
                           BeerMapper beerMapper) {
        this.beerRepository = beerRepository;
        this.breweryRepository = breweryRepository;
        this.beerMapper = beerMapper;
    }

    @Override
    public BeerDTO findById(long id) {
        return beerMapper.toDto(
                findEntityById(id)
        );
    }

    private BeerEntity findEntityById(Long id) {
        return this.beerRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(String.format(BEER_NOT_FOUND, id)));
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
    public Long createBeer(BeerDTO beerDTO) {
        var beerEntity = beerMapper.toEntity(beerDTO);
        var brewery = breweryRepository.findById(beerDTO.getBrewery().getId());
        brewery.getBeers().add(beerEntity);
        beerEntity.setBrewery(brewery);
        beerRepository.persist(beerEntity);
        return beerEntity.getId();
    }

    @Override
    @Transactional
    public void updateBeer(BeerDTO beerDTO) {
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
    public List<BeerDTO> findByCreatorName(String creator) {
        return beerRepository.list("select b from BeerEntity b left join CreatorEntity c " +
                        "on b.creatorId=c.id where c.firstName = ?1", creator)
                .stream().map(
                        beerMapper::toDto
                ).toList();
    }

    @Override
    @Transactional
    public List<BeerDTO> findByCreatorFirstNameAndLastName(String firstName, String lastName) {
        return beerRepository.list("select b from BeerEntity b left join CreatorEntity c " +
                                "on b.creatorId=c.id where c.firstName = ?1 and c.lastName = ?2",
                        firstName, lastName)
                .stream().map(beerMapper::toDto
                ).toList();
    }
}
