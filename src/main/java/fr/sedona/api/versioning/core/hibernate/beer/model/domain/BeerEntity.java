package fr.sedona.api.versioning.core.hibernate.beer.model.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Beer entity
 */
@Getter
@Setter
@Entity
public class BeerEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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
