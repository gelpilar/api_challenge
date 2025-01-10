package com.api.crud.controllers;

import com.api.crud.models.CaracteristicaModel;
import com.api.crud.models.PaisModel;
import com.api.crud.services.CarecteristicasService;
import com.api.crud.services.PaisesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisesServices paisesServices;

    @GetMapping
    public ArrayList<PaisModel> getCaracteristicas()
    {
        return  paisesServices.getPaises();
    }
}
