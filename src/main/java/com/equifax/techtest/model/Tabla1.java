package com.equifax.techtest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(Coordenada.class)
public class Tabla1 {
    @Id
    private String lat;
    @Id
    private String lng;
    private String campo1;
    private String campo2;

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getCampo1() {
        return campo1;
    }

    public String getCampo2() {
        return campo2;
    }
}
