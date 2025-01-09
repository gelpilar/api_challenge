package com.api.crud.models.auxiliar;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UserAuxiliarModel {

    private  Long id;
    private  String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public UserAuxiliarModel(Long id, String email, String nombre) {
        this.id = id;
        this.email = email;
        Nombre = nombre;
    }

    private String  Nombre;

}
