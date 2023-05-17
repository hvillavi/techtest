package com.equifax.techtest.service;

import com.equifax.techtest.model.Coordenada;
import com.equifax.techtest.model.Tabla1;
import com.equifax.techtest.repository.Tabla1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Tabla1Service {

    private final Tabla1Repository tabla1Repository;

    @Autowired
    public Tabla1Service(Tabla1Repository iTabla1Repository) {
        tabla1Repository = iTabla1Repository;
    }

    public Resultado obtenerTabla1(Coordenada coordenada) {
        Resultado resultado = new Resultado(coordenada.getLat(), coordenada.getLng());
        Tabla1 tabla1;
        try {
            tabla1 = tabla1Repository.getById(coordenada);
            Datos datos = new Datos(tabla1.getCampo1(), tabla1.getCampo2());
            resultado.setDatos(datos);

        } catch (RuntimeException e) {

        }
        return resultado;
    }
}
