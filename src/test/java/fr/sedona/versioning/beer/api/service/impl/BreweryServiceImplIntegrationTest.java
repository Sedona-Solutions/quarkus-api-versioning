package fr.sedona.versioning.beer.api.service.impl;

import fr.sedona.versioning.beer.api.service.BreweryService;
import fr.sedona.versioning.beer.api.service.impl.BreweryServiceImpl;
import io.quarkus.test.junit.QuarkusTest;

import javax.inject.Inject;

/**
 * Test suite for {@link BreweryServiceImpl}
 */
@QuarkusTest
class BreweryServiceImplIntegrationTest {

    @Inject
    BreweryService searchService;


}
