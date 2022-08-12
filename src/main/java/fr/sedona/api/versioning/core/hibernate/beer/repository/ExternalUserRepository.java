package fr.sedona.api.versioning.core.hibernate.beer.repository;

import fr.sedona.api.versioning.core.hibernate.beer.model.domain.CreatorEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

/**
 * External user repository
 */
@ApplicationScoped
public class ExternalUserRepository implements PanacheRepository<CreatorEntity> {
}
