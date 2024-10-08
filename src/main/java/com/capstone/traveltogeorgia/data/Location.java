package com.capstone.traveltogeorgia.data;

import java.util.Objects;

public class Location {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Season season;
    private Type type;

    public Location() {
    }

    public Location(Long id, String name, String description, String imageUrl, Season season, Type type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.season = season;
        this.type = type;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id)
                && Objects.equals(name, location.name)
                && Objects.equals(description, location.description)
                && Objects.equals(imageUrl, location.imageUrl)
                && season == location.season
                && type == location.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, imageUrl, season, type);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", season=" + season +
                ", type=" + type +
                '}';
    }
}