package com.m486.persistencia;

import com.m486.config.ConnexioMysql;
import com.m486.model.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAOImpl implements PersonaDAO {

    private ConnexioMysql conn;

    public PersonaDAOImpl(ConnexioMysql connMysql) {
        this.conn = connMysql;
    }

    /**
     * @param persona
     * @return
     */
    @Override
    public boolean afegir(Persona persona) {

        String query = "INSERT INTO persona (NIF, NOM, EDAT) VALUES (?, ?, ?)";

        try (Connection con = this.conn.getConnexio();
             PreparedStatement ps = con.prepareStatement(query);) {
            ps.setString(1, persona.getNif());
            ps.setString(2, persona.getNombre());
            ps.setInt(3, persona.getEdat());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new PersonaException("Error afegint persona", e);
        }

    }

    /**
     * @param nif
     * @return Persona
     */
    @Override
    public Persona cercarPerNif(String nif) {
        String query = "SELECT * FROM persona WHERE NIF = ?";
        Persona persona = null;

        try (Connection con = this.conn.getConnexio();
        PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, nif);
            ResultSet rs = ps.executeQuery();
            persona = new Persona(rs.getString("NIF"), rs.getString("NOM"), rs.getInt("EDAT"));
        } catch (SQLException e) {
            throw new PersonaException("No se a trobat la persona per NIF",e);
        }
        return persona;
    }

    /**
     * @return
     */
    @Override
    public List<Persona> cercarTots() {
        String query = "SELECT * FROM persona";
        List<Persona> persones = new ArrayList<>();

        try(Connection con = this.conn.getConnexio();
            Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                persones.add(new Persona(rs.getString(1),rs.getString(2),rs.getInt(3)));
            }

        } catch (SQLException e) {
            throw new PersonaException("Error cercant persones", e);
        }

        return persones;



    }
}
