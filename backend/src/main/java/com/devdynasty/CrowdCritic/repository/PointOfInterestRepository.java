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


    @Query(value = "SELECT poi.* FROM point_of_interest poi INNER JOIN category cat ON poi.categories = cat.id INNER JOIN prefecture pref ON poi.prefecture = pref.id INNER JOIN regions reg ON pref.region = reg.id " +
            "WHERE to_tsvector(poi.description || ' ' || poi.name || ' ' || cat.name || ' ' || pref.name || ' ' || reg.name || ' ' || poi.address) @@ to_tsquery(':text')", nativeQuery = true)
    List<PointOfInterest> findEverywhere(String text);

    @Query(value = "SELECT poi.* FROM point_of_interest poi " +
            "WHERE ST_DWithIn(ST_MakePoint(poi.latitude, poi.longitude)::geography, ST_MakePoint(:lat, :lon)::geography, :meters)", nativeQuery = true)
    List<PointOfInterest> findByDistance(Double lat, Double lon, Double meters);

    @Query(value = "SELECT poi.* FROM point_of_interest poi INNER JOIN point_of_interest_keywords poi_key ON poi.id = poi_key.point_of_interest_id INNER JOIN keyword key ON poi_key.keywords = key.id " +
            "WHERE to_tsvector(key.word) @@ to_tsquery(':keyword')", nativeQuery = true)
    List<PointOfInterest> findByKeyword(String keyword);

    @Query(value = "SELECT poi.* FROM point_of_interest poi INNER JOIN category cat ON poi.categories = cat.id " +
            "WHERE to_tsvector(cat.name) @@ to_tsquery(':category')", nativeQuery = true)
    List<PointOfInterest> findByCategory(String category);
}
