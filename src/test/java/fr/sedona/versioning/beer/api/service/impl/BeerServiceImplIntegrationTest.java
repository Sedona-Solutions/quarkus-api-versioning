package fr.sedona.versioning.beer.api.service.impl;

import fr.sedona.versioning.beer.api.model.dto.BeerDTO;
import fr.sedona.versioning.beer.api.service.BeerService;
import fr.sedona.versioning.beer.api.service.impl.BeerServiceImpl;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test suite for {@link BeerServiceImpl}
 */
@QuarkusTest
class BeerServiceImplIntegrationTest {

    @Inject
    BeerService searchService;

    @Test
    void searchByName_should_return_expected_beers_with_caasae_insensitive_query() {
        // given
        String query = "Skoll";

        // when
        List<BeerDTO> results = searchService.findByName(query);

        // then
        assertEquals(1, results.size());
        assertEquals("Skoll", results.get(0).getName());
    }

    @Test
    void searchByCreatorName_should_return_expected_beers_with_last_name_in_query() {
        // given
        String query = "Edouard";

        // when
        List<BeerDTO> results = searchService.findByCreatorName(query);

        // then
        assertEquals(4, results.size());
        List<String> beers = results.stream().map(BeerDTO::getName).sorted().collect(Collectors.toList());
        assertEquals(List.of("1664", "Carlsberg", "Skoll", "Tigre Bock"), beers);
    }

    @Test
    void searchByCreatorName_should_return_expected_beers_with_first_name_in_query() {
        // given
        String query = "Edouard";

        // when
        List<BeerDTO> results = searchService.findByCreatorName(query);

        // then
        assertEquals(4, results.size());
        List<String> beers = results.stream().map(BeerDTO::getName).sorted().collect(Collectors.toList());
        assertEquals(List.of("1664", "Carlsberg", "Skoll", "Tigre Bock"), beers);
    }

    @Test
    void searchByCreatorFirstNameAndLastName_should_return_no_beers_with_different_case_first_name() {
        // given
        String firstName = "Edouard";

        // when
        List<BeerDTO> results = searchService.findByCreatorFirstNameAndLastName(firstName, null);

        // then
        assertTrue(results.isEmpty());
    }

    @Test
    void searchByCreatorFirstNameAndLastName_should_return_expected_beers_with_first_and_last_name() {
        // given
        String firstName = "Edouard";
        String lastName = "Lamotte";

        // when
        List<BeerDTO> results = searchService.findByCreatorFirstNameAndLastName(firstName, lastName);

        // then
        assertEquals(4, results.size());
        List<String> beers = results.stream().map(BeerDTO::getName).sorted().collect(Collectors.toList());
        assertEquals(List.of("1664", "Carlsberg", "Skoll", "Tigre Bock"), beers);
    }
}
