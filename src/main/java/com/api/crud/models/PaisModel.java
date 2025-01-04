package com.api.crud.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Pais")
public class PaisModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Long Id;

    @Column
    private  String icono;

    @Column(unique = true)
    private  String nombre;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    @Override
    public String toString() {
        return "PaisModel{" +
                "Id=" + Id +
                ", icono='" + icono + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
