package com.m486.persistencia;

import java.sql.SQLException;

public class PersonaException extends RuntimeException {
    public PersonaException(String messatge, SQLException ex) {
    }
}
