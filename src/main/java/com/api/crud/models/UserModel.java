package com.api.crud.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Check;

@Entity
@Table(name = "Usuario")
@RequiredArgsConstructor

public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    @Column(unique = true)
    @Email(message = "formato mail invalido")

    private  String email;

    @Column
    @Size(min = 8, message = "contraseña no valida")
    private String  contra;
    @Column
    private String  Nombre;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
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
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }


}
