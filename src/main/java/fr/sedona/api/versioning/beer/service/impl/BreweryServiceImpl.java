package fr.sedona.api.versioning.beer.service.impl;

import fr.sedona.api.versioning.beer.model.dto.BreweryDTO;
import fr.sedona.api.versioning.beer.model.mapper.BeerMapper;
import fr.sedona.api.versioning.beer.service.BreweryService;
import fr.sedona.api.versioning.core.hibernate.beer.model.domain.BreweryEntity;
import fr.sedona.api.versioning.core.hibernate.beer.repository.BreweryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;

/**
 * Default implementation of brewery service
 */
@ApplicationScoped
public class BreweryServiceImpl implements BreweryService {

    public static final String BREWERY_NOT_FOUND = "No brewery found with id '%d'";

    private final BreweryRepository breweryRepository;

    private final BeerMapper beerMapper;

    @Inject
    public BreweryServiceImpl(BreweryRepository breweryRepository,
                              BeerMapper beerMapper) {
        this.breweryRepository = breweryRepository;
        this.beerMapper = beerMapper;
    }

    @Override
    @Transactional
    public BreweryDTO createBrewery(BreweryDTO breweryDTO) {
        breweryRepository.persist(beerMapper.toEntity(breweryDTO));
        return beerMapper.toDto(beerMapper.toEntity(breweryDTO));
    }

    @Override
    @Transactional
    public void updateBrewery(BreweryDTO breweryDTO) {
        var breweryEntity = this.findEntityById(breweryDTO.getId());
        breweryRepository.persist(beerMapper.toExistingEntity(breweryDTO, breweryEntity));
    }

    @Override
    @Transactional
    public void deleteBrewery(long id) {
        this.findById(id);
        breweryRepository.deleteById(id);
    }

    @Override
    public List<BreweryDTO> findByName(String name) {
        return this.breweryRepository.findByName(name).stream().map(beerMapper::toDto).toList();
    }

    @Override
    public BreweryDTO findById(long id) {
        return beerMapper.toDto(findEntityById(id));
    }

    private BreweryEntity findEntityById(long id) {
        return breweryRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(String.format(BREWERY_NOT_FOUND, id)));
    }

    @Override
    public List<BreweryDTO> findAll() {
        return breweryRepository.findAll().stream().map(beerMapper::toDto).toList();
    }
}
