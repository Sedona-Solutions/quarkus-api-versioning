package fr.sedona.api.versioning.core.hibernate.beer.model.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Brewery entity
 */
@Getter
@Setter
@Entity
public class BreweryEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private BreweryType type;

    private String country;

    @OneToMany(mappedBy = "brewery", fetch = FetchType.EAGER)
    private List<BeerEntity> beers;
}
