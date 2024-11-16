package com.geomatic.pois_api.repository;

import com.geomatic.pois_api.domain.Poi;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoiRepository extends MongoRepository<Poi, String> {
}
