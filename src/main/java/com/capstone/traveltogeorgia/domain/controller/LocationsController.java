package com.capstone.traveltogeorgia.domain.controller;


import com.capstone.traveltogeorgia.data.service.LocationsService;
import com.capstone.traveltogeorgia.domain.model.Region;
import com.capstone.traveltogeorgia.domain.model.Season;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        model.addAttribute("regions", locationsService.getAllRegions());

        return "locations";
    }

    @GetMapping("/{locationId}")
    public String getLocationById(@PathVariable long locationId, Model model) {
        model.addAttribute("location", locationsService.getLocationById(locationId));

        model.addAttribute("similarBySeason", locationsService.getLocationsBySeason(
                locationsService.getLocationById(locationId).getSeason(), locationId
        ));
        model.addAttribute("similarByRegion", locationsService.getLocationsByRegion(
                locationsService.getLocationById(locationId).getRegion(), locationId
        ));

        return "location";
    }

    @GetMapping("/by_search_param")
    public String getLocationByName(@RequestParam String param, Model model) {
        if (param != null && param.isBlank()) return "redirect:/locations";

        model.addAttribute("locations", locationsService.getLocationsByName(param));
        return "locations";
    }

    @GetMapping("/by_season/{season}")
    public String getLocationsBySeason(@PathVariable String season, Model model) {
        model.addAttribute("locations", locationsService.getLocationsBySeason(
                getEnum(Season.class, season), -1L)
        );
        return "locations";
    }

    @GetMapping("/by_region/{region}")
    public String getLocationsByRegion(@PathVariable String region, Model model) {
        model.addAttribute("locations", locationsService.getLocationsByRegion(
                getEnum(Region.class, region), -1L));
        model.addAttribute("regions", locationsService.getAllRegions());
        return "locations";
    }

    @GetMapping("/api/regions")
    @ResponseBody
    public List<String> getAllRegions() {
        List<String> regions = locationsService.getAllRegions().stream().map(Region::toString).toList();
        return regions;
    }

    private static <T extends Enum<T>> T getEnum(Class<T> enumClass, String name) {
//        return Enum.valueOf(enumClass, name.toUpperCase());

        for(T e : enumClass.getEnumConstants()) {
            if (e.toString().toUpperCase().contains(name.toUpperCase())) return e;
        }

        return null;
    }
}