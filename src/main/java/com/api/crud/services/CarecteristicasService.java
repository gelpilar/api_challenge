package com.api.crud.services;

import com.api.crud.models.CaracteristicaModel;
import com.api.crud.repositories.ICarecteristicasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CarecteristicasService {
    @Autowired
    private ICarecteristicasRepository carecteristicasRepository;

    public ArrayList<CaracteristicaModel> getCara()
    {
        return  (ArrayList<CaracteristicaModel>) carecteristicasRepository.findAll();
    }
}
