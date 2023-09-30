package com.ejercicio.multicapas.domain.service;

import com.ejercicio.multicapas.domain.dto.request.RequestDto;
import com.ejercicio.multicapas.domain.dto.VehicleWithoutServiceDto;
import com.ejercicio.multicapas.persistence.entity.Vehicle;
import com.ejercicio.multicapas.persistence.repository.IVehicleRepository;
import com.ejercicio.multicapas.persistence.repository.VehicleRepositoryImpl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService {

    private IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    @Override
    public RequestDto save(RequestDto vehicle) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        Vehicle toSave = mapper.convertValue(vehicle, Vehicle.class);
        Vehicle savedVehicle = vehicleRepository.save(toSave);

        return mapper.convertValue(savedVehicle, RequestDto.class);
    }

    @Override
    public List<VehicleWithoutServiceDto> getAll() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return vehicleRepository.findAll()
                .stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleWithoutServiceDto.class))
                .toList();
    }

    @Override
    public List<VehicleWithoutServiceDto> getByDate(LocalDate since, LocalDate to) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return vehicleRepository.findByDate(since, to)
                .stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleWithoutServiceDto.class))
                .toList();
    }

    @Override
    public List<VehicleWithoutServiceDto> getByPrice(Integer since, Integer to) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return vehicleRepository.findByPrice(since, to)
                .stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleWithoutServiceDto.class))
                .toList();
    }

    @Override
    public RequestDto getById(Long id) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        return mapper.convertValue(vehicleRepository.findById(id), RequestDto.class);
    }

}
