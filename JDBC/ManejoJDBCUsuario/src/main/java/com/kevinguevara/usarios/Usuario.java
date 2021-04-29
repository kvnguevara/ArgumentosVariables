package com.kevinguevara.usarios;

public class Usuario {
    private int idUsuario;;
    private String user;
    private String password;

    //Constructores


    public Usuario() {
    }

    public Usuario(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Usuario(int idUsuario, String user, String password) {
        this.idUsuario = idUsuario;
        this.user = user;
        this.password = password;
    }

    //Metodos get and set

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Usuario{");
        sb.append("idUsuario=").append(idUsuario);
        sb.append(", user='").append(user).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
