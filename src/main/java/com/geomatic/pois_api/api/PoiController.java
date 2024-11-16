package com.geomatic.pois_api.api;

import com.geomatic.pois_api.domain.Poi;
import com.geomatic.pois_api.service.PoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pois")
public class PoiController {

    @Autowired
    private PoiService poiService;

    @GetMapping
    public List<Poi> getAllPois() {
        return poiService.getAllPois();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poi> getPoiById(@PathVariable String id) {
        return poiService.getPoiById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Poi addPoi(@RequestBody Poi poi) {
        return poiService.addPoi(poi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoi(@PathVariable String id) {
        poiService.deletePoi(id);
        return ResponseEntity.noContent().build();
    }
}
