package com.example.turagentstvo.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
public class TourDTO {

    private long id;

    private ZonedDateTime starDate;

    private ZonedDateTime finishDate;

    private BigDecimal price;

    private String type;
}
