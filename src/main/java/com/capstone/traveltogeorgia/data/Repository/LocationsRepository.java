package com.capstone.traveltogeorgia.data.Repository;

import com.capstone.traveltogeorgia.data.model.LocationEntity;
import com.capstone.traveltogeorgia.domain.model.Region;
import com.capstone.traveltogeorgia.domain.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationsRepository extends JpaRepository<LocationEntity, Long> {

    List<LocationEntity> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description);

    List<LocationEntity> findBySeasonInAndIdNot(List<Season> seasons, Long id);

    List<LocationEntity> findByRegionAndIdNot(Region region, Long id);
}