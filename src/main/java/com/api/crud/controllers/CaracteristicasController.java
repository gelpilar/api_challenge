package com.api.crud.controllers;

import com.api.crud.models.CaracteristicaModel;
import com.api.crud.services.CarecteristicasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/caracteristicas")
public class CaracteristicasController {

    @Autowired
    private CarecteristicasService caracteristicasService;

    @GetMapping
    public ArrayList<CaracteristicaModel> getCaracteristicas()
    {
        return  caracteristicasService.getCara();
    }
}
