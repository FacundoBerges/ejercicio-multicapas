package com.ejercicio.multicapas.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Service {

    private LocalDate date;
    private Integer kilometers;
    private String descriptions;

}
