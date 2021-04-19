package com.kevinguevara.model;

public class Persona {
    private String nombre;
    private int id;
    private  int edad;
    private String apellidos;

    public Persona(String nombre,int edad,int id,String apellidos) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
        this.apellidos = apellidos;
    }

    public Persona() {
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Persona{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", id=").append(id);
        sb.append(", edad=").append(edad);
        sb.append(", apellidos='").append(apellidos).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
