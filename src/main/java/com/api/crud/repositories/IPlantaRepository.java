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

    @Transactional
    @Modifying
    @Query("Update PlantaModel set id_pais=null where id= :id")
    void desasociarPais(Long idPais);


}
