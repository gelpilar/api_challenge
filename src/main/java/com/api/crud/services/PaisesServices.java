package com.api.crud.services;

import com.api.crud.models.PaisModel;
import com.api.crud.repositories.IPaisRepository;
import com.api.crud.repositories.IPlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class PaisesServices {
    @Autowired
    IPaisRepository paisRepository;

    public ArrayList<PaisModel> getPaises()
    {
        return (ArrayList<PaisModel>) paisRepository.findAll();
    }

}
