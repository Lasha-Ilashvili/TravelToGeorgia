package com.capstone.traveltogeorgia.data.model;

import com.capstone.traveltogeorgia.domain.model.Region;
import com.capstone.traveltogeorgia.domain.model.Season;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "LOCATION")
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Enumerated
    @Column(name = "SEASON_ID")
    private Season season;

    @Enumerated
    @Column(name = "REGION_ID")
    private Region region;

    public LocationEntity() {
    }

    public LocationEntity(Long id, String name, String description, String imageUrl, Season season, Region region) {
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

        LocationEntity locationEntity = (LocationEntity) o;

        return Objects.equals(id, locationEntity.id)
                && Objects.equals(name, locationEntity.name)
                && Objects.equals(description, locationEntity.description)
                && Objects.equals(imageUrl, locationEntity.imageUrl)
                && season == locationEntity.season
                && region == locationEntity.region;
     }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, imageUrl, season, region);
    }

    @Override
    public String toString() {
        return "LocationEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", season=" + season +
                ", region=" + region +
                '}';
    }
}