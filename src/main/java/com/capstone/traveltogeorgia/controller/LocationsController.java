package com.capstone.traveltogeorgia.controller;


import com.capstone.traveltogeorgia.data.Season;
import com.capstone.traveltogeorgia.service.LocationsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/locations")
public class LocationsController {

    private final LocationsService locationsService;

    public LocationsController(LocationsService locationsService) {
        this.locationsService = locationsService;
    }

    @GetMapping
    public String getAllLocations(@RequestParam(name = "name", required = false) String name,
                                  @RequestParam(name = "season", required = false) String season,
                                  Model model) {
        if (shouldRedirect(name)) return "redirect:/locations";

        model.addAttribute("locations", locationsService.getAllLocations(name, season));
        addAttributes(model, name);

        return "locations";
    }

    private static boolean shouldRedirect(String... parameters) {
        for (String parameter : parameters) {
            if (parameter != null && parameter.isBlank()) {
                return true;
            }
        }

        return false;
    }

    @GetMapping("/{locationId}")
    public String getLocationById(@PathVariable long locationId, Model model) {
        model.addAttribute("location", locationsService.getLocationById(locationId));
        return "location";
    }

    private static void addAttributes(Model model, String name) {
        model.addAttribute("summer", Season.SUMMER.getDisplayName());
        model.addAttribute("winter", Season.WINTER.getDisplayName());
        model.addAttribute("name", name);
    }
}