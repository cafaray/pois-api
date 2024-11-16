package com.geomatic.pois_api.service;

import com.geomatic.pois_api.domain.Poi;
import com.geomatic.pois_api.repository.PoiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoiService {

    @Autowired
    private PoiRepository poiRepository;

    public List<Poi> getAllPois() {
        return poiRepository.findAll();
    }

    public Optional<Poi> getPoiById(String id) {
        return poiRepository.findById(id);
    }

    public Poi addPoi(Poi poi) {
        return poiRepository.save(poi);
    }

    public void deletePoi(String id) {
        poiRepository.deleteById(id);
    }
}
