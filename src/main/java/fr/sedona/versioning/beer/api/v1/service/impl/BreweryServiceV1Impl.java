package fr.sedona.versioning.beer.api.v1.service.impl;

import fr.sedona.versioning.beer.core.hibernate.beer.model.domain.BreweryEntity;
import fr.sedona.versioning.beer.core.hibernate.beer.repository.BreweryRepository;
import fr.sedona.versioning.beer.api.v1.model.dto.BreweryDtoV1;
import fr.sedona.versioning.beer.api.v1.model.mapper.BreweryMapperV1;
import fr.sedona.versioning.beer.api.v1.service.BreweryServiceV1;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;

/**
 * V1 implementation of brewery service
 */
@ApplicationScoped
public class BreweryServiceV1Impl implements BreweryServiceV1 {

    public static final String BREWERY_NOT_FOUND = "No brewery found with id '%d'";

    private final BreweryRepository breweryRepository;

    private final BreweryMapperV1 breweryMapper;

    @Inject
    public BreweryServiceV1Impl(BreweryRepository breweryRepository,
                                BreweryMapperV1 breweryMapper) {
        this.breweryRepository = breweryRepository;
        this.breweryMapper = breweryMapper;
    }

    @Override
    @Transactional
    public Long createBrewery(BreweryDtoV1 breweryDTO) {
        var breweryEntity = breweryMapper.toEntity(breweryDTO);
        breweryRepository.persist(breweryEntity);
        return breweryEntity.getId();
    }

    @Override
    @Transactional
    public void updateBrewery(BreweryDtoV1 breweryDTO) {
        var breweryEntity = this.findEntityById(breweryDTO.getId());
        breweryRepository.persist(breweryMapper.toExistingEntity(breweryDTO, breweryEntity));
    }

    @Override
    @Transactional
    public void deleteBrewery(long id) {
        this.findById(id);
        breweryRepository.deleteById(id);
    }

    @Override
    public List<BreweryDtoV1> findByName(String name) {
        return this.breweryRepository.findByName(name).stream().map(breweryMapper::toDto).toList();
    }

    @Override
    public BreweryDtoV1 findById(long id) {
        return breweryMapper.toDto(findEntityById(id));
    }

    private BreweryEntity findEntityById(long id) {
        return breweryRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(String.format(BREWERY_NOT_FOUND, id)));
    }

    @Override
    public List<BreweryDtoV1> findAll() {
        return breweryRepository.findAll().stream().map(breweryMapper::toDto).toList();
    }
}
