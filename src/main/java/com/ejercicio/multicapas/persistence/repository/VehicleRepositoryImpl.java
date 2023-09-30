package com.ejercicio.multicapas.persistence.repository;


import com.ejercicio.multicapas.persistence.entity.Vehicle;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private final List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public List<Vehicle> findAll() {
        return vehicles.stream().toList();
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        vehicles.add(vehicle);

        return vehicle;
    }

    @Override
    public List<Vehicle> findByDate(LocalDate since, LocalDate to) {
        return vehicles
                .stream()
                .filter(vehicle -> vehicle.getManufacturingDate().isAfter(since) && vehicle.getManufacturingDate().isBefore(to))
                .toList();
    }

    @Override
    public List<Vehicle> findByPrice(Integer since, Integer to) {
        return vehicles
                .stream()
                .filter(vehicle -> vehicle.getPrice() >= since && vehicle.getPrice() <= to)
                .toList();
    }

    @Override
    public Vehicle findById(Long id) {
        int index = Integer.parseInt( Long.toString( id ) );

        return vehicles.get( index );
    }
}
