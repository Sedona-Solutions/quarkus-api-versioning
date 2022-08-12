package fr.sedona.api.versioning.core.hibernate.beer.repository;

import fr.sedona.api.versioning.core.hibernate.beer.model.domain.BeerEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

/**
 * Beer repository
 */
@ApplicationScoped
public class BeerRepository implements PanacheRepository<BeerEntity> {

    public List<BeerEntity> findByName(String name) {
        return list("name", name);
    }
}
