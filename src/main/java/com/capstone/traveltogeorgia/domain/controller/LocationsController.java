package com.capstone.traveltogeorgia.domain.controller;


import com.capstone.traveltogeorgia.data.service.LocationsService;
import com.capstone.traveltogeorgia.domain.model.Location;
import com.capstone.traveltogeorgia.domain.model.Region;
import com.capstone.traveltogeorgia.domain.model.Season;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping("/locations")
public class LocationsController {

    private final LocationsService locationsService;

    public LocationsController(LocationsService locationsService) {
        this.locationsService = locationsService;
    }

    @GetMapping
    public String getAllLocations(Model model) {
        model.addAttribute("locations", locationsService.getAllLocations());
        addCommonAttributes(model);
        return "locations";
    }

    @GetMapping("/{locationId}")
    public String getLocationById(@PathVariable long locationId, Model model) {
        Location location = locationsService.getLocationById(locationId);
        model.addAttribute("location", location);
        model.addAttribute("similarBySeason", locationsService.getLocationsBySeason(
                location.getSeason(), locationId
        ));
        model.addAttribute("similarByRegion", locationsService.getLocationsByRegion(
                location.getRegion(), locationId
        ));
        addCommonAttributes(model);
        return "location";
    }

    @GetMapping("/by_search_param")
    public String getLocationByName(@RequestParam String param, Model model) {
        if (param != null && param.isBlank()) return "redirect:/locations";
        model.addAttribute("locations", locationsService.getLocationsByName(param));
        addCommonAttributes(model);
        return "locations";
    }

    @GetMapping("/by_season/{season}")
    public String getLocationsBySeason(@PathVariable String season, Model model) {
        model.addAttribute("locations", locationsService.getLocationsBySeason(
                getEnum(Season.class, season), -1L)
        );
        addCommonAttributes(model);
        return "locations";
    }

    @GetMapping("/by_region/{region}")
    public String getLocationsByRegion(@PathVariable String region, Model model) {
        model.addAttribute("locations", locationsService.getLocationsByRegion(
                getEnum(Region.class, region), -1L));
        addCommonAttributes(model);
        return "locations";
    }

    @GetMapping("/regions")
    public String getRegions(Model model) {
        addCommonAttributes(model);
        return "locations";
    }

    private void addCommonAttributes(Model model) {
        model.addAttribute("allRegions", locationsService.getAllRegions());
        model.addAttribute("allSeasons", Arrays.copyOf(Season.values(), Season.values().length - 1));
    }

    private static <T extends Enum<T>> T getEnum(Class<T> enumClass, String name) {
        for (T e : enumClass.getEnumConstants()) {
            if (e.toString().toUpperCase().contains(name.toUpperCase())) return e;
        }
        return null;
    }
}