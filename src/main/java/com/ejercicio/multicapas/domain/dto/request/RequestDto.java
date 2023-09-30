package com.ejercicio.multicapas.domain.dto.request;

import com.ejercicio.multicapas.domain.dto.ServiceDto;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {

    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Integer price;
    private String currency;
    private List<ServiceDto> services;
    private Integer countOfOwners;

}
