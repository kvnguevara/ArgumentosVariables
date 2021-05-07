package com.kevinguevara.datos;

public interface Iconsultas {
    static final String SQL_SELECT = "SELECT id_persona,nombre,apellido,mail,telefono FROM persona";
    static final String SQL_INSERT = "INSERT INTO persona(nombre,apellido,mail,telefono) VALUES(?, ?, ?, ?)";
    static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ? ";
    static final String SQL_UPDATE = "UPDATE persona SET nombre = ?,apellido = ? ,mail = ? ,telefono = ? WHERE id_persona = ?";
    static final String SQL_SELECT_USER = "SELECT * FROM usuario";
    static final String SQL_INSERT_USER = "INSERT INTO usuario(user,password) VALUES(?,?)";
    static final String SQL_DELETE_USER = "DELETE FROM usuario WHERE id_usuario = ?";
    static final String SQL_UPDATE_USER = "UPDATE usuario SET user = ?, password = ? WHERE id_usuario = ?";
}
