package com.capstone.traveltogeorgia.service;

import com.capstone.traveltogeorgia.data.Location;
import com.capstone.traveltogeorgia.data.Season;
import com.capstone.traveltogeorgia.data.Type;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationsService {

    public List<Location> getAllLocations(String name, String season) {
        List<Location> locations = generateMockLocations();

        if (name == null && season == null) {
            return locations;
        }

        if (name == null) {
            return getLocationsBySeason(locations, Season.valueOf(season.toUpperCase()));
        }

        return getLocationsByName(locations, name);
    }

    public Location getLocationById(long locationId) {
        return generateMockLocations().stream().filter(location ->
                location.getId() == locationId
        ).findFirst().orElse(null);
    }

    public List<Location> getLocationsByName(List<Location> locations, String name) {
        return locations.stream().filter(location ->
                location.getName().equalsIgnoreCase(name)
        ).toList();
    }

    public List<Location> getLocationsBySeason(List<Location> locations, Season season) {
        return locations.stream().filter(location ->
                location.getSeason() == season || location.getSeason() == Season.WINTER_SUMMER
        ).toList();
    }

    private static List<Location> generateMockLocations() {
        List<Location> locations = new ArrayList<>();
        locations.add(new Location(1L, "Kazbegi", "A mountainous region", "https://i0.wp.com/www.traveldiaryparnashree.com/wp-content/uploads/2020/05/iman-gozal-5iQWgow3_S0-unsplash-scaled.jpg?resize=1080%2C675&ssl=1", Season.WINTER, Type.ADVENTURE));
        locations.add(new Location(2L, "Batumi", "A coastal city", "https://api.visitbatumi.com/media/images/1920x1280/3691eee0c7324105a58f00c677f08eb3.webp", Season.SUMMER, Type.CULTURAL));
        locations.add(new Location(3L, "Tbilisi", "Capital city of Georgia", "https://aroundtheworldwithme.com/wp-content/uploads/2021/08/Tbilisi-2.jpg", Season.WINTER_SUMMER, Type.CULTURAL));
        locations.add(new Location(4L, "Svaneti", "A beautiful highland region", "https://www.turebi.ge/uploads/photos/tours1/large/37005_1.jpg", Season.WINTER_SUMMER, Type.NATURE));
        return locations;
    }
}
