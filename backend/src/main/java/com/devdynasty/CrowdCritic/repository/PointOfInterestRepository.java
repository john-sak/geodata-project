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


    @Query(value = "SELECT poi.* FROM point_of_interest poi INNER JOIN category cat ON poi.categories = cat.id INNER JOIN prefecture pref ON poi.prefecture = pref.id INNER JOIN region reg ON pref.region = reg.id " +
            "WHERE to_tsvector('greek', COALESCE(poi.description, '') || ' ' || COALESCE(poi.name, '') || ' ' || COALESCE(cat.name, '') || ' ' || COALESCE(pref.name, '') || ' ' || COALESCE(reg.name, '') || ' ' || COALESCE(poi.address, '')) @@ to_tsquery('greek', ?1)", nativeQuery = true)
    List<PointOfInterest> findEverywhere(String tsquery);

    @Query(value = "SELECT poi.* FROM point_of_interest poi " +
            "WHERE ST_DWithin(CAST(ST_MakePoint(poi.latitude, poi.longitude) AS geography), CAST(ST_MakePoint(?1, ?2) AS geography), ?3)", nativeQuery = true)
    List<PointOfInterest> findByDistance(Double lat, Double lon, Double meters);

    @Query(value = "SELECT poi.* FROM point_of_interest poi INNER JOIN point_of_interest_keywords poi_key ON poi.id = poi_key.point_of_interest_id INNER JOIN keyword kwrd ON poi_key.keywords = kwrd.id " +
            "WHERE to_tsvector('greek', kwrd.word) @@ to_tsquery('greek', ?1)", nativeQuery = true)
    List<PointOfInterest> findByKeyword(String tsquery);

    @Query(value = "SELECT poi.* FROM point_of_interest poi " +
            "WHERE poi.categories IN ?1", nativeQuery = true)
    List<PointOfInterest> findByCategory(List<Integer> categoryIDs);

    @Query(value = "SELECT usr.email FROM app_user usr INNER JOIN area_of_interest aoi ON usr.appuser_id = aoi.appuser_id " +
            "WHERE (point(?1, ?2) <@ circle(point(aoi.latitude, aoi.longitude), aoi.distance))", nativeQuery = true)
    List<String> getEmailsForPoint(Double lat, Double lon);
}
