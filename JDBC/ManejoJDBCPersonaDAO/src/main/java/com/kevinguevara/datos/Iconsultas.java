package com.kevinguevara.datos;

public interface Iconsultas {
    static final String SQL_SELECT = "SELECT id_persona,nombre,apellido,mail,telefono FROM persona";
    static final String SQL_INSERT = "INSERT INTO persona(nombre,apellido,mail,telefono) VALUES(?, ?, ?, ?)";
    static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ? ";
    static final String SQL_UPDATE = "UPDATE persona SET nombre = ?,apellido = ? ,mail = ? ,telefono = ? WHERE id_persona = ?";
}
