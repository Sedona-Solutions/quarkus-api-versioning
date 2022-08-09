package fr.sedona.api.versioning.beer.model.mapper;

import fr.sedona.api.versioning.beer.model.BeerEntity;
import fr.sedona.api.versioning.beer.model.BreweryEntity;
import fr.sedona.api.versioning.beer.model.CreatorEntity;
import fr.sedona.api.versioning.beer.model.dto.BeerDTO;
import fr.sedona.api.versioning.beer.model.dto.BreweryDTO;
import fr.sedona.api.versioning.beer.model.dto.CreatorDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-09T20:51:12+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@ApplicationScoped
public class BeerMapperImpl implements BeerMapper {

    @Override
    public BeerDTO toDto(BeerEntity entity) {
        if ( entity == null ) {
            return null;
        }

        BeerDTO beerDTO = new BeerDTO();

        if ( entity.id != null ) {
            beerDTO.setId( entity.id );
        }
        beerDTO.setName( entity.getName() );
        beerDTO.setAlcoholLevel( entity.getAlcoholLevel() );
        List<String> list = entity.getIngredients();
        if ( list != null ) {
            beerDTO.setIngredients( new ArrayList<String>( list ) );
        }
        beerDTO.setBrewery( toDto( entity.getBrewery() ) );
        beerDTO.setCreator( toDto( entity.getCreator() ) );

        return beerDTO;
    }

    @Override
    public BreweryDTO toDto(BreweryEntity entity) {
        if ( entity == null ) {
            return null;
        }

        BreweryDTO breweryDTO = new BreweryDTO();

        if ( entity.id != null ) {
            breweryDTO.setId( entity.id );
        }
        breweryDTO.setName( entity.getName() );
        breweryDTO.setType( entity.getType() );
        breweryDTO.setCountry( entity.getCountry() );

        return breweryDTO;
    }

    @Override
    public CreatorDTO toDto(CreatorEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CreatorDTO creatorDTO = new CreatorDTO();

        creatorDTO.setLastName( entity.getLastName() );
        creatorDTO.setFirstName( entity.getFirstName() );

        return creatorDTO;
    }

    @Override
    public CreatorEntity toEntity(CreatorDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CreatorEntity creatorEntity = new CreatorEntity();

        creatorEntity.setLastName( dto.getLastName() );
        creatorEntity.setFirstName( dto.getFirstName() );

        return creatorEntity;
    }

    @Override
    public BeerEntity toEntity(BeerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        BeerEntity beerEntity = new BeerEntity();

        beerEntity.setName( dto.getName() );
        beerEntity.setBrewery( toEntity( dto.getBrewery() ) );
        List<String> list = dto.getIngredients();
        if ( list != null ) {
            beerEntity.setIngredients( new ArrayList<String>( list ) );
        }
        beerEntity.setAlcoholLevel( dto.getAlcoholLevel() );
        beerEntity.setCreator( toEntity( dto.getCreator() ) );
        beerEntity.id = dto.getId();

        return beerEntity;
    }

    @Override
    public BreweryEntity toEntity(BreweryDTO dto) {
        if ( dto == null ) {
            return null;
        }

        BreweryEntity breweryEntity = new BreweryEntity();

        breweryEntity.setName( dto.getName() );
        breweryEntity.setType( dto.getType() );
        breweryEntity.setCountry( dto.getCountry() );
        breweryEntity.id = dto.getId();

        return breweryEntity;
    }
}
