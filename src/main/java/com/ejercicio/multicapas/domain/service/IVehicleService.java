package com.ejercicio.multicapas.domain.service;

import com.ejercicio.multicapas.domain.dto.request.RequestDto;
import com.ejercicio.multicapas.domain.dto.VehicleWithoutServiceDto;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleService {

    RequestDto save(RequestDto vehicle);
    List<VehicleWithoutServiceDto> getAll();
    List<VehicleWithoutServiceDto> getByDate(LocalDate since, LocalDate to);
    List<VehicleWithoutServiceDto> getByPrice(Integer since, Integer to);
    RequestDto getById(Long id);


}
