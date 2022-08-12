package fr.sedona.api.versioning.v2.beer.service.impl;

import fr.sedona.api.versioning.core.hibernate.beer.model.domain.BreweryEntity;
import fr.sedona.api.versioning.core.hibernate.beer.repository.BreweryRepository;
import fr.sedona.api.versioning.v2.beer.model.dto.BreweryDtoV2;
import fr.sedona.api.versioning.v2.beer.model.mapper.BreweryMapperV2;
import fr.sedona.api.versioning.v2.beer.service.BreweryServiceV2;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;

/**
 * V2 implementation of brewery service
 */
@ApplicationScoped
public class BreweryServiceV2Impl implements BreweryServiceV2 {

    public static final String BREWERY_NOT_FOUND = "No brewery found with id '%d'";

    private final BreweryRepository breweryRepository;

    private final BreweryMapperV2 breweryMapper;

    @Inject
    public BreweryServiceV2Impl(BreweryRepository breweryRepository,
                                BreweryMapperV2 breweryMapper) {
        this.breweryRepository = breweryRepository;
        this.breweryMapper = breweryMapper;
    }

    @Override
    @Transactional
    public Long createBrewery(BreweryDtoV2 breweryDTO) {
        var breweryEntity = breweryMapper.toEntity(breweryDTO);
        breweryRepository.persist(breweryEntity);
        return breweryEntity.getId();
    }

    @Override
    @Transactional
    public void updateBrewery(BreweryDtoV2 breweryDTO) {
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
    public List<BreweryDtoV2> findByName(String name) {
        return this.breweryRepository.findByName(name).stream().map(breweryMapper::toDto).toList();
    }

    @Override
    public BreweryDtoV2 findById(long id) {
        return breweryMapper.toDto(findEntityById(id));
    }

    private BreweryEntity findEntityById(long id) {
        return breweryRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(String.format(BREWERY_NOT_FOUND, id)));
    }

    @Override
    public List<BreweryDtoV2> findAll() {
        return breweryRepository.findAll().stream().map(breweryMapper::toDto).toList();
    }
}