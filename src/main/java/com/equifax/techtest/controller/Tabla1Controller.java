package com.equifax.techtest.controller;

import com.equifax.techtest.model.Coordenada;
import com.equifax.techtest.service.Resultado;
import com.equifax.techtest.service.Tabla1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tabla1")
public class Tabla1Controller {
    private final Tabla1Service tabla1Service;

    @Autowired
    public Tabla1Controller(Tabla1Service iTabla1Service) {
        tabla1Service = iTabla1Service;
    }

    @GetMapping("tabla1")
    public @ResponseBody ResponseEntity<Resultado> obtenerTabla1(@RequestParam("lat") String lat,
                                                                 @RequestParam("lng") String lng) {

        Coordenada coordenada = new Coordenada(lat, lng);
        Resultado resultado = tabla1Service.obtenerTabla1(coordenada);

        return ResponseEntity.ok(resultado);
    }
}
