package fr.sedona.api.versioning.v1.beer.service.impl;

import fr.sedona.api.versioning.core.hibernate.beer.repository.BreweryRepository;
import fr.sedona.api.versioning.v1.beer.model.dto.BreweryDtoV1;
import fr.sedona.api.versioning.v1.beer.model.mapper.BreweryMapperV1;
import fr.sedona.api.versioning.v1.beer.service.BreweryServiceV1;

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
    public BreweryDtoV1 createBrewery(BreweryDtoV1 breweryDTO) {
        breweryRepository.persist(breweryMapper.toEntity(breweryDTO));
        return breweryMapper.toDto(breweryMapper.toEntity(breweryDTO));
    }

    @Override
    public void updateBrewery(BreweryDtoV1 breweryDTO) {
        this.findById(breweryDTO.getId());
        breweryMapper.toEntity(breweryDTO);
    }

    @Override
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
        return breweryMapper.toDto(breweryRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(String.format(BREWERY_NOT_FOUND, id))));
    }

    @Override
    public List<BreweryDtoV1> findAll() {
        return breweryRepository.findAll().stream().map(breweryMapper::toDto).toList();
    }
}
