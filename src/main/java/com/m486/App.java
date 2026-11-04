package com.m486;

import com.m486.config.ConnexioMysql;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ConnexioMysql connexioMysql = new ConnexioMysql();

        try {
            connexioMysql.getConnexio();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos " + e.getMessage());
        }

    }
}
