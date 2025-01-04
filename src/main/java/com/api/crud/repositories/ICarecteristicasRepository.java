package com.api.crud.repositories;

import com.api.crud.models.CaracteristicaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarecteristicasRepository extends JpaRepository<CaracteristicaModel,Long> {
}
