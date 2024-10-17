package com.capstone.traveltogeorgia;

import com.capstone.traveltogeorgia.data.Repository.LocationsRepository;
import com.capstone.traveltogeorgia.data.model.LocationEntity;
import com.capstone.traveltogeorgia.data.service.LocationsService;
import com.capstone.traveltogeorgia.domain.model.Location;
import com.capstone.traveltogeorgia.domain.model.Region;
import com.capstone.traveltogeorgia.domain.model.Season;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LocationsServiceTest {

    @Mock
    private LocationsRepository locationsRepository;

    @InjectMocks
    private LocationsService locationsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllLocations() {
        // Arrange
        List<LocationEntity> mockEntities = List.of(
                new LocationEntity(1L, "Gergeti Trinity Church", "", "", Season.WINTER, Region.GURIA),
                new LocationEntity(2L, "Truso Valley", "", "", Season.SUMMER, Region.MTSKHETA_MTIANETI)
        );
        when(locationsRepository.findAll()).thenReturn(mockEntities);

        // Act
        List<Location> result = locationsService.getAllLocations();

        // Assert
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals("Gergeti Trinity Church", result.get(0).getName());
        assertEquals(Season.WINTER, result.get(0).getSeason());
        assertEquals(Region.GURIA, result.get(0).getRegion());
    }

    @Test
    void testGetLocationById() {
        // Arrange
        LocationEntity mockEntity = new LocationEntity(3L, "Gomismta", "", "", Season.SUMMER, Region.GURIA);
        when(locationsRepository.findById(3L)).thenReturn(Optional.of(mockEntity));

        // Act
        Location result = locationsService.getLocationById(3L);

        // Assert
        assertNotNull(result);
        assertEquals(3L, result.getId());
        assertEquals("Gomismta", result.getName());
        assertEquals(Season.SUMMER, result.getSeason());
        assertEquals(Region.GURIA, result.getRegion());
    }

    @Test
    void testGetLocationById_NotFound() {
        // Arrange
        when(locationsRepository.findById(10L)).thenReturn(Optional.empty());

        // Act
        Location result = locationsService.getLocationById(10L);

        // Assert
        assertNull(result);
    }

    @Test
    void testGetLocationsByName() {
        // Arrange
        List<LocationEntity> mockEntities = List.of(
                new LocationEntity(1L, "Gomismta", "", "", Season.SUMMER, Region.GURIA),
                new LocationEntity(2L, "Gomismta", "", "", Season.WINTER, Region.MTSKHETA_MTIANETI)
        );
        when(locationsRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase("Gomi", "Gomi"))
                .thenReturn(mockEntities);

        // Act
        List<Location> result = locationsService.getLocationsByName("Gomi");

        // Assert
        assertEquals(2, result.size());
        assertEquals("Gomismta", result.get(0).getName());
    }

    @Test
    void testGetLocationsByRegion() {
        // Arrange
        List<LocationEntity> mockEntities = List.of(
                new LocationEntity(1L, "Gergeti Trinity Church", "", "", Season.WINTER, Region.GURIA)
        );
        when(locationsRepository.findByRegionAndIdNot(Region.GURIA, -1L)).thenReturn(mockEntities);

        // Act
        List<Location> result = locationsService.getLocationsByRegion(Region.GURIA, -1L);

        // Assert
        assertEquals(1, result.size());
        assertEquals(Region.GURIA, result.get(0).getRegion());
    }

    @Test
    void testGetAllRegions() {
        // Act
        List<Region> result = locationsService.getAllRegions();

        // Assert
        assertEquals(3, result.size()); // Adjust if you add more regions
        assertTrue(result.contains(Region.IMERETI));
        assertTrue(result.contains(Region.GURIA));
        assertTrue(result.contains(Region.MTSKHETA_MTIANETI));
    }
}