package com.api.crud.models;


import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;


@Entity
@Table(name = "Planta")
public class PlantaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(nullable = false, columnDefinition = "bigint default 0")
    private Long alertasMedias= Long.valueOf(0);
    @Column(nullable = false, columnDefinition = "bigint default 0")
    private Long alertasRojas= Long.valueOf(0);
    @Column(nullable = false, columnDefinition = "bigint default 0")
    private Long cantidadDesabilitados =  Long.valueOf(0);
    @Column(nullable = false, columnDefinition = "bigint default 0")
    private Long cantidadLecturas = Long.valueOf(0);

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pais", referencedColumnName = "id", nullable = false)
    private PaisModel pais;

    public PlantaModel(String nombre, PaisModel pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public PlantaModel() {
    }

    public PlantaModel(Long id, String nombre, Long alertasMedias, Long alertasRojas, Long cantidadDesabilitados, Long cantidadLecturas, PaisModel pais) {
        this.id = id;
        this.nombre = nombre;
        this.alertasMedias = alertasMedias;
        this.alertasRojas = alertasRojas;
        this.cantidadDesabilitados = cantidadDesabilitados;
        this.cantidadLecturas = cantidadLecturas;
        this.pais = pais;
    }

    public PaisModel getPais() {
        return pais;
    }

    public void setPais(PaisModel pais) {
        this.pais = pais;
    }

    public Long getCantidadLecturas() {
        return cantidadLecturas;
    }

    public void setCantidadLecturas(Long cantidadLecturas) {
        this.cantidadLecturas = cantidadLecturas;
    }

    public Long getCantidadDesabilitados() {
        return cantidadDesabilitados;
    }

    public void setCantidadDesabilitados(Long cantidadDesabilitados) {
        this.cantidadDesabilitados = cantidadDesabilitados;
    }

    public Long getAlertasRojas() {
        return alertasRojas;
    }

    public void setAlertasRojas(Long alertasRojas) {
        this.alertasRojas = alertasRojas;
    }

    public Long getAlertasMedias() {
        return alertasMedias;
    }

    public void setAlertasMedias(Long alertasMedias) {
        this.alertasMedias = alertasMedias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }
    @Override
    public String toString() {
        return "PlantaModel{nombre='" + nombre + "', pais=" + pais + "}";
    }
}
