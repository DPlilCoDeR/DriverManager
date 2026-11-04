package com.m486.persistencia;

import com.m486.model.Persona;

import java.util.List;

public interface PersonaDAO {
    boolean afegir(Persona persona);
    Persona cercarPerNif(String nif);
    List<Persona> cercarTots();
    boolean eliminar(String nif);
    boolean actualizar(Persona persona);
}
