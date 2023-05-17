package com.equifax.techtest.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Resultado {
    private String lat_input;
    private String lng_input;
    private Datos datos;

    public Resultado(String lat_input, String lng_input) {
        this.lat_input = lat_input;
        this.lng_input = lng_input;
        this.datos = datos;
    }

    public String getLat_input() {
        return lat_input;
    }

    public String getLng_input() {
        return lng_input;
    }

    public Datos getDatos() {
        return datos;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }
}
