package com.example.turagentstvo.dtos;

import lombok.Data;
@Data
public class TransportDTO {

    private long id;

    private String type;

    private String model;

    private int year;

    private int countPlaces;
}
