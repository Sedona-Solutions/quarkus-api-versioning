package fr.sedona.api.versioning.core.hibernate.beer.repository;

import fr.sedona.api.versioning.core.hibernate.beer.model.domain.BreweryEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

/**
 * Beer repository
 */
@ApplicationScoped
public class BreweryRepository implements PanacheRepository<BreweryEntity> {

    public List<BreweryEntity> findByName(String name) {
        return list("name", name);
    }
}
