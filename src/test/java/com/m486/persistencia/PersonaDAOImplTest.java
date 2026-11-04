package com.m486.persistencia;


import com.m486.config.ConnexioMysql;
import com.m486.model.Persona;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonaDAOImplTest {

    private static PersonaDAO pDAO;

    @BeforeAll
    public static void setUp() throws Exception {
       pDAO = new PersonaDAOImpl(new ConnexioMysql());
    }

    @Test
    public void testAfegir() {
        Persona persona = new Persona("123456Q", "Jason", 30);
        Persona persona2 = new Persona("123457B", "Jeremias", 66);


        boolean afegit = pDAO.afegir(persona);
        boolean afegit2 = pDAO.afegir(persona2);

        assertTrue(afegit);
        assertTrue(afegit2);
    }

    @Test
    public void testThrowAfegirException() {
        Persona persona = new Persona("123456Q", "Jason", 30);

        assertThrows(PersonaException.class, () -> pDAO.afegir(persona));
    }

    @Test
    public void testCercarPerNif() {
        String nif = "12345678A";
        Persona persona = pDAO.cercarPerNif(nif);

        assertEquals(nif, persona.getNif());
    }

    @Test
    public void testCercarTots() {
    }

    @Test
    public void testEliminar() {
    }

    @Test
    public void testActualizar() {
    }
}