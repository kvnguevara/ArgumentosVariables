package com.kevinguevara.domain;

public class UsuarioDTO {
    private int idUser;
    private String userName;
    private String password;

    //Constructores

    public UsuarioDTO(int idUser, String userName, String password) {
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
    }

    public UsuarioDTO() {
    }
    //Gett and setter

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //Metodo toString

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UsuarioDTO{");
        sb.append("idUser=").append(idUser);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
