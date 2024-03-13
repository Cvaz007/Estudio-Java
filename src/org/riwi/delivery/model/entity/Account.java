package org.riwi.delivery.model.entity;

import org.riwi.delivery.model.Rol;

public class Account {
    private String id;
    private String email;
    private String password;
    private Rol rol;

    public Account() {
    }

    public Account(String id, String email, String password, Rol rol) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
