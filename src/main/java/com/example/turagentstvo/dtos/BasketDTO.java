package com.example.turagentstvo.dtos;

import com.example.turagentstvo.entities.Sale;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BasketDTO {

    private long id;

    private String status;

    private BigDecimal totalCost;

    private long saleId;
}
