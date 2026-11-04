package com.m486.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexio {

    private final String cadenaConnexio;
    private final String usuari;
    private final String contrasenya;

    public Connexio() {
        cadenaConnexio = "jdbc:mysql://localhost:3306/persones";
        usuari = "app";
        contrasenya = "1234";
    }

    public Connexio(String cadenaConnexio, String usuari, String contrasenya) {
        this.cadenaConnexio = cadenaConnexio;
        this.usuari = usuari;
        this.contrasenya = contrasenya;
    }

    /**
     * Obté  una instància de la classe Connection, amb la connexió oberta amb el SGBD
     * a la BD indicada a la cadena de connexió.
     *
        * @return torna la connexió oberta
     */
    public Connection getConnexio() throws SQLException {

        Connection con = DriverManager.getConnection(cadenaConnexio, usuari, contrasenya);
        System.out.println("Connexió oberta?: " + !con.isClosed());

        return con;
    }


}

