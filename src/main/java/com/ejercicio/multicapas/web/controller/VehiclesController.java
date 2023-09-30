package com.ejercicio.multicapas.web.controller;

import com.ejercicio.multicapas.domain.dto.request.RequestDto;
import com.ejercicio.multicapas.domain.dto.response.ResponseDto;
import com.ejercicio.multicapas.domain.service.IVehicleService;
import com.ejercicio.multicapas.domain.service.VehicleServiceImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehiclesController {

    private IVehicleService vehicleService;

    public VehiclesController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody RequestDto vehicle) {
        return ResponseEntity.ok(vehicleService.save(vehicle) != null
                ? new ResponseDto("Vehiculo guardado correctamente")
                : new ResponseDto("Error al guardar vehiculo"));
    }

    @GetMapping
    public ResponseEntity<?> getWithoutService(){
        return ResponseEntity.ok(vehicleService.getAll());
    }

    @GetMapping("/dates")
    public ResponseEntity<?> getAllByDate(
            @RequestParam(name = "since", required = false, defaultValue = "1900-01-01") LocalDate since,
            @RequestParam(name = "to", required = false, defaultValue = "2100-12-31") LocalDate to){
        return ResponseEntity.ok(vehicleService.getByDate(since, to));
    }

    @GetMapping("/prices")
    public ResponseEntity<?> getAllByPrice(
            @RequestParam(name = "since", required = false, defaultValue = "0") Integer since,
            @RequestParam(name = "to", required = false, defaultValue = "9999999999") Integer to){
        return ResponseEntity.ok(vehicleService.getByPrice(since, to));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long vehicleId){
        return ResponseEntity.ok(vehicleService.getById(vehicleId - 1));
    }


}
