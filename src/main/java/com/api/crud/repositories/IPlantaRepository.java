package com.api.crud.repositories;

import com.api.crud.models.PlantaModel;
import com.api.crud.models.UserModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPlantaRepository extends JpaRepository<PlantaModel, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE PlantaModel p SET p.nombre = :nombre, p.alertasMedias = :alertasMedias, p.alertasRojas = :alertasRojas, p.cantidadDesabilitados = :cantidadDesabilitados, p.cantidadLecturas = :cantidadLecturas, p.pais.id = :id_pais WHERE p.id = :id")
    Integer actualizarPlanta(Long id, String nombre, Long alertasMedias, Long alertasRojas, Long cantidadDesabilitados, Long cantidadLecturas, Long id_pais);
    @Modifying
    @Transactional
    @Query("UPDATE PlantaModel SET pais = NULL WHERE id = :idPais")
    void desasociarPais(Long idPais);

    @Transactional
    @Query("SELECT SUM(p.alertasMedias)  from PlantaModel as p")
    Long alertasMedias();

    @Transactional
    @Query("SELECT SUM(p.alertasRojas)  from PlantaModel as p")
    Long alertasRojas();

    @Transactional
    @Query("SELECT SUM(p.cantidadLecturas) FROM PlantaModel as p")
    Long lecturas();

    @Transactional
    @Query("SELECT SUM(p.cantidadDesabilitados) from PlantaModel as p")
    Long desabilitados();




}
