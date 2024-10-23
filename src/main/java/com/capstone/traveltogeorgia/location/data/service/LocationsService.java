package com.capstone.traveltogeorgia.location.data.service;

import com.capstone.traveltogeorgia.location.data.Repository.LocationsRepository;
import com.capstone.traveltogeorgia.location.data.model.LocationEntity;
import com.capstone.traveltogeorgia.location.domain.model.Location;
import com.capstone.traveltogeorgia.location.domain.model.Region;
import com.capstone.traveltogeorgia.location.domain.model.Season;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationsService {

    private final LocationsRepository locationsRepository;

    @Autowired
    public LocationsService(LocationsRepository locationsRepository) {
        this.locationsRepository = locationsRepository;
    }

    public List<Location> getAllLocations() {
        return locationsRepository.findAll().stream().map(LocationsService::toDomain).toList();
    }

    public List<Region> getAllRegions() {
        return List.of(Region.values());
    }

    public Location getLocationById(long locationId) {
        return locationsRepository.findById(locationId).map(LocationsService::toDomain).orElse(null);
    }

    public List<Location> getLocationsByName(String param) {
        return locationsRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(param, param)
                .stream().map(LocationsService::toDomain).toList();
    }

    public List<Location> getLocationsBySeason(Season season, Long id) {
        List<Season> seasons = (season == Season.WINTER_SUMMER) ? List.of(Season.values())
                : List.of(season, Season.WINTER_SUMMER);

        return locationsRepository.findBySeasonInAndIdNot(seasons, id)
                .stream().map(LocationsService::toDomain).toList();
    }

    public List<Location> getLocationsByRegion(Region region, Long id) {
        return locationsRepository.findByRegionAndIdNot(region, id)
                .stream().map(LocationsService::toDomain).toList();
    }

    private static Location toDomain(LocationEntity entity) {
        return new Location(entity.getId(), entity.getName(), entity.getDescription(),
                entity.getImageUrl(), entity.getSeason(), entity.getRegion());
    }
}