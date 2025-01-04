package com.api.crud.models.auxiliar;

public class RequestPlantaPost {
    private String nombre;
    private Long id_pais;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId_pais() {
        return id_pais;
    }

    public void setId_pais(Long id_pais) {
        this.id_pais = id_pais;
    }
}
