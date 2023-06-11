package com.devdynasty.CrowdCritic.repository;

import com.devdynasty.CrowdCritic.model.PointOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PointOfInterestRepository extends JpaRepository<PointOfInterest,Integer> {


    @Override
    Optional<PointOfInterest> findById(Integer id);


    List<PointOfInterest> findAll();


    Optional<PointOfInterest> findPointsOfInterestByName(String name);


    @Query("SELECT * FROM point_of_interest poi INNER JOIN categories cat ON poi.categories = cat.id INNER JOIN prefecture pref ON poi.prefecture = pref.id INNER JOIN regions reg ON pref.id = reg.id " +
            "WHERE to_tsvector(poi.description || ' ' || poi.name || ' ' || cat.name || ' ' || pref.name || ' ' || reg.name || ' ' || poi.address) @@ to_tsquery(':text')")
    List<PointOfInterest> findEverywhere(String text);

    @Query("")
    List<PointOfInterest> findByDistance(Double latMin, Double latMax, Double lonMin, Double lonMax);

    @Query("")
    List<PointOfInterest> findByKeyword(String keyword);

    @Query("")
    List<PointOfInterest> findByCategory(String category);
}
