package fr.sedona.versioning.beer.api.v1.service;

import fr.sedona.versioning.beer.api.v1.model.dto.BeerDtoV1;
import fr.sedona.versioning.beer.api.v1.service.BeerServiceV1;
import fr.sedona.versioning.beer.api.v1.service.impl.BeerServiceV1Impl;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test suite for {@link BeerServiceV1Impl}
 */
@QuarkusTest
class BeerServiceV1ImplIntegrationTest {

    @Inject
    BeerServiceV1 searchService;

    @Test
    void searchByName_should_return_expected_beers_with_caasae_insensitive_query() {
        // given
        String query = "Skoll";

        // when
        List<BeerDtoV1> results = searchService.findByName(query);

        // then
        assertEquals(1, results.size());
        assertEquals("Skoll", results.get(0).getName());
    }

    @Test
    void searchByCreatorName_should_return_expected_beers_with_last_name_in_query() {
        // given
        String query = "Edouard";

        // when
        List<BeerDtoV1> results = searchService.findByCreatorName(query);

        // then
        assertEquals(4, results.size());
        List<String> beers = results.stream().map(BeerDtoV1::getName).sorted().collect(Collectors.toList());
        assertEquals(List.of("1664", "Carlsberg", "Skoll", "Tigre Bock"), beers);
    }

    @Test
    void searchByCreatorName_should_return_expected_beers_with_first_name_in_query() {
        // given
        String query = "Edouard";

        // when
        List<BeerDtoV1> results = searchService.findByCreatorName(query);

        // then
        assertEquals(4, results.size());
        List<String> beers = results.stream().map(BeerDtoV1::getName).sorted().collect(Collectors.toList());
        assertEquals(List.of("1664", "Carlsberg", "Skoll", "Tigre Bock"), beers);
    }

    @Test
    void searchByCreatorFirstNameAndLastName_should_return_no_beers_with_different_case_first_name() {
        // given
        String firstName = "Edouard";

        // when
        List<BeerDtoV1> results = searchService.findByCreatorFirstNameAndLastName(firstName, null);

        // then
        assertTrue(results.isEmpty());
    }

    @Test
    void searchByCreatorFirstNameAndLastName_should_return_expected_beers_with_first_and_last_name() {
        // given
        String firstName = "Edouard";
        String lastName = "Lamotte";

        // when
        List<BeerDtoV1> results = searchService.findByCreatorFirstNameAndLastName(firstName, lastName);

        // then
        assertEquals(4, results.size());
        List<String> beers = results.stream().map(BeerDtoV1::getName).sorted().collect(Collectors.toList());
        assertEquals(List.of("1664", "Carlsberg", "Skoll", "Tigre Bock"), beers);
    }
}