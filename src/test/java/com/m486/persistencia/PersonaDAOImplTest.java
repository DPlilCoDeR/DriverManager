package com.m486.persistencia;


import com.m486.config.ConnexioMysql;
import com.m486.model.Persona;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonaDAOImplTest {

    private Connection c;
    private PersonaDAOImpl personaDAO;
    private PersonaDAO pDAO;

    @BeforeEach
    public void setUp() throws Exception {

       pDAO = new PersonaDAOImpl(new ConnexioMysql());

    }

    @AfterEach
    public void restaurarBD() {
        pDAO.eliminar("69696969G");
    }

    @Test
    public void testAfegir() {

        String nif = "69696969G";
        Persona pTest = new Persona(nif, "Gyro", 24);

        boolean afegit = pDAO.afegir(pTest);

        assertTrue(afegit);

    }

    @Test
    public void testThrowAfegirException() {
        Persona pTest = new Persona(null, "Gyro", 24);

        assertThrows(PersonaException.class, () -> pDAO.afegir(pTest));
    }

    @Test
    public void testCercarPerNif() {
        String nif = "69696969G";
        Persona pTest = new Persona(nif, "Gyro", 24);
        pDAO.afegir(pTest);
        Persona persona = pDAO.cercarPerNif(nif);

        assertEquals(nif, persona.getNif());
    }

    @Test
    public void testCercarPerNifNull() {
        String nif = "69696969G";
        Persona pTest = new Persona(nif, "Gyro", 24);
        pDAO.afegir(pTest);

        assertNull(pDAO.cercarPerNif("0000000000W"));
    }

    @Test
    public void testCercarTots() {
        List<Persona> personas = pDAO.cercarTots();

        assertNotNull(personas);
    }

    @Test
    public void testEliminar() {
        String nif = "99999999D";
        Persona pTest = new Persona(nif, "Dio", 120);
        pDAO.afegir(pTest);
        boolean eliminat = pDAO.eliminar(nif);

        assertTrue(eliminat);
    }

    @Test
    public void testNoEliminat() {
        assertFalse(pDAO.eliminar("1234567890"));
    }

    @Test
    public void testActualizar() {
        String nif = "69696969G";
        Persona pTest = new Persona(nif, "Gyro", 24);
        pDAO.afegir(pTest);
        Persona p = new Persona(nif, "Jonny", 24);
        boolean actual = pDAO.actualizar(p);
        assertTrue(actual);
    }
}