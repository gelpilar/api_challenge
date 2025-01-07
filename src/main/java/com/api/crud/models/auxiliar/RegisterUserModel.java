package com.api.crud.models.auxiliar;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class RegisterUserModel {
    @Email(message = "formato de mail invalido")
    private  String email;
    @Size(min = 8, message = "El numero minimo de caracteres es de 8")
    private String  contra;
    private String  nombre;

    public RegisterUserModel(String email, String contra, String nombre) {
        this.email = email;
        this.contra = contra;
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
