package com.api.crud.controllers;


import com.api.crud.models.PlantaModel;
import com.api.crud.models.UserModel;
import com.api.crud.models.auxiliar.RequestLoginModel;
import com.api.crud.models.auxiliar.RequestPlanta;
import com.api.crud.models.auxiliar.RequestPlantaPost;
import com.api.crud.services.PlantasService;
import com.api.crud.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/planta")
public class PlantaController {

    @Autowired
    private PlantasService plantasService;
    @PostMapping
    public PlantaModel postPlanta(@RequestBody RequestPlantaPost planta) {
        try {
            System.out.println("2");

            return plantasService.postPlantas(planta);
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al crear la planta", e);
        }
    }
    @PutMapping("/{id}")
    public Integer putPlanta(@PathVariable Long id, @RequestBody RequestPlanta planta) {
        return plantasService.putPlantas(id, planta);
    }

    @GetMapping
    public  ArrayList<PlantaModel> getPlantas()
    {
        return  plantasService.getPlantas();
    }

    @DeleteMapping("/{id}")
    public PlantaModel deletePlanta(@PathVariable Long id)
    {
        return plantasService.deletePlanta(id);
    }






}
