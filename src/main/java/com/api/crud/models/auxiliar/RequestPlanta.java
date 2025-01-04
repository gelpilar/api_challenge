package com.api.crud.models.auxiliar;

import jakarta.persistence.Column;

public class RequestPlanta {
    private String nombre;
    private Long alertasMedias;
    private Long alertasRojas;
    private Long cantidadDesabilitados;
    private Long cantidadLecturas;
    private Long id_pais;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getAlertasMedias() {
        return alertasMedias;
    }

    public void setAlertasMedias(Long alertasMedias) {
        this.alertasMedias = alertasMedias;
    }

    public Long getAlertasRojas() {
        return alertasRojas;
    }

    public void setAlertasRojas(Long alertasRojas) {
        this.alertasRojas = alertasRojas;
    }

    public Long getCantidadDesabilitados() {
        return cantidadDesabilitados;
    }

    public void setCantidadDesabilitados(Long cantidadDesabilitados) {
        this.cantidadDesabilitados = cantidadDesabilitados;
    }

    public Long getCantidadLecturas() {
        return cantidadLecturas;
    }

    public void setCantidadLecturas(Long cantidadLecturas) {
        this.cantidadLecturas = cantidadLecturas;
    }

    public Long getId_pais() {
        return id_pais;
    }

    public void setId_pais(Long id_pais) {
        this.id_pais = id_pais;
    }
}
