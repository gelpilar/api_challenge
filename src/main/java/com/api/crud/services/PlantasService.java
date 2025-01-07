package com.api.crud.services;

import com.api.crud.models.PaisModel;
import com.api.crud.models.PlantaModel;
import com.api.crud.models.auxiliar.RequestPlanta;
import com.api.crud.models.auxiliar.RequestPlantaPost;
import com.api.crud.repositories.IPaisRepository;
import com.api.crud.repositories.IPlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service

public class PlantasService {
    @Autowired
    IPlantaRepository plantaRepository;
    @Autowired
    IPaisRepository paisRepository;

    public  PlantaModel deletePlanta(Long id)
    {
        try {

            plantaRepository.desasociarPais(id);
            PlantaModel planta = plantaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Planta no encontrada con ID: " + id));
            plantaRepository.delete(planta);

            return planta;
        }catch (Error e)
        {
            throw new Error("Error" + e.toString());
        }

    }
    public ArrayList<PlantaModel> getPlantas()
    {
        return (ArrayList<PlantaModel>) plantaRepository.findAll();
    }

    public Integer putPlantas(Long id, RequestPlanta planta )
    {
        return  plantaRepository.actualizarPlanta(id,planta.getNombre(),planta.getAlertasMedias(),planta.getAlertasRojas(), planta.getCantidadDesabilitados(), planta.getCantidadLecturas(),planta.getId_pais() );
    }

    public PlantaModel postPlantas(RequestPlantaPost planta) {
        PaisModel pais = null;

        try {
            pais = paisRepository.findById(planta.getId_pais()).orElse(null);
            System.out.println(pais.toString());


            PlantaModel pl = new PlantaModel(planta.getNombre(), pais);
            System.out.println(pl.toString());
            PlantaModel p= plantaRepository.save(pl);
            if(p==null)
            {
                throw new RuntimeException("Error al crear la planta: " );

            }

            return  p;

        } catch (Exception e) {
            throw new RuntimeException("Error al crear la planta: " + e.getMessage(), e);
        }
    }

    public Long getAlertasMedias()
    {
        return plantaRepository.alertasMedias();
    }
    public Long getAlertasRojas()
    {
        return plantaRepository.alertasRojas();
    }
    public Long getLecturas()
    {
        return plantaRepository.lecturas();
    }
    public Long getDesabilitados()
    {
        return plantaRepository.desabilitados();
    }

    public Optional<PlantaModel> getPlanta(Long id)
    {
        return plantaRepository.findById(id);
    }

}
