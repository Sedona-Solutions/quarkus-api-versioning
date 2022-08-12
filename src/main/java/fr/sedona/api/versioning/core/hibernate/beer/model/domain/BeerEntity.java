package fr.sedona.api.versioning.core.hibernate.beer.model.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Beer entity
 */
@Getter
@Setter
@Entity
public class BeerEntity extends PanacheEntity {

    private String name;

    @ManyToOne
    @JoinColumn
    private BreweryEntity brewery;

    @ElementCollection
    private List<String> ingredients;

    private float alcoholLevel;

    @ManyToOne
    @JoinColumn
    private CreatorEntity creator;
}
