package com.capstone.traveltogeorgia.domain.model;

import java.util.Objects;

public class Location {

    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Season season;
    private Region region;

    public Location() {
    }

    public Location(Long id, String name, String description, String imageUrl, Season season, Region region) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.season = season;
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location Location = (Location) o;

        return Objects.equals(id, Location.id)
                && Objects.equals(name, Location.name)
                && Objects.equals(description, Location.description)
                && Objects.equals(imageUrl, Location.imageUrl)
                && season == Location.season
                && region == Location.region;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, imageUrl, season, region);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", season=" + season +
                ", region='" + region + '\'' +
                '}';
    }
}