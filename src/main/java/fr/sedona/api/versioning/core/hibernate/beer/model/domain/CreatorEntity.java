package fr.sedona.api.versioning.core.hibernate.beer.model.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * External use entity : for demo purpose we store it in the same application as
 * the beers and breweries, but it should be in another application
 */
@Getter
@Setter
@Entity
public class CreatorEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String lastName;

    private String firstName;
}
