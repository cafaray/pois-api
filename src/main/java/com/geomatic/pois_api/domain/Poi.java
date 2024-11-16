package com.geomatic.pois_api.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "pois")
public class Poi {

    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private Coordenadas coordenadas;
    private String fechaRegistro;

    @Data
    public static class Coordenadas {
        private double latitud;
        private double longitud;
    }
}
