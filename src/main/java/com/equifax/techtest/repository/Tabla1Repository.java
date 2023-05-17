package com.equifax.techtest.repository;

import com.equifax.techtest.model.Coordenada;
import com.equifax.techtest.model.Tabla1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Tabla1Repository extends JpaRepository<Tabla1, Coordenada> {
}
