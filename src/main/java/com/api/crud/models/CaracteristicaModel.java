package com.api.crud.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Caracteristica")
public class CaracteristicaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;


    private  String nombre;

    private  Long primer;
    private  Long segundo;
    private  Long tercero;
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

    public Long getPrimer() {
        return primer;
    }

    public void setPrimer(Long primer) {
        this.primer = primer;
    }

    public Long getSegundo() {
        return segundo;
    }

    public void setSegundo(Long segundo) {
        this.segundo = segundo;
    }

    public Long getTercero() {
        return tercero;
    }

    public void setTercero(Long tercero) {
        this.tercero = tercero;
    }
}
