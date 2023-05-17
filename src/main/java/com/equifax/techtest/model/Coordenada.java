package com.equifax.techtest.model;

import java.io.Serializable;
import java.util.Objects;

public class Coordenada implements Serializable {
    private String lat;
    private String lng;

    public Coordenada(String iLat, String iLng) {
        lat = iLat;
        lng = iLng;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordenada that = (Coordenada) o;
        return Objects.equals(lat, that.lat) &&
                Objects.equals(lng, that.lng);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lat, lng);
    }
}
