package com.ejercicio.multicapas.persistence.repository;

import com.ejercicio.multicapas.domain.dto.VehicleWithoutServiceDto;
import com.ejercicio.multicapas.domain.dto.request.RequestDto;
import com.ejercicio.multicapas.persistence.entity.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleRepository {

    List<Vehicle> findAll();
    Vehicle save(Vehicle vehicle);
    List<Vehicle> findByDate(LocalDate since, LocalDate to);
    List<Vehicle> findByPrice(Integer since, Integer to);
    Vehicle findById(Long id);

}
