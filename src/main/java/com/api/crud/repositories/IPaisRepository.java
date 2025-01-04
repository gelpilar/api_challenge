package com.api.crud.repositories;

import com.api.crud.models.PaisModel;
import com.api.crud.models.PlantaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaisRepository extends JpaRepository<PaisModel, Long> {
}
