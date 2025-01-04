package com.api.crud.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(unique = true)
    private  String email;

    @Column
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
