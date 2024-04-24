package com.example.turagentstvo.dtos;

import com.example.turagentstvo.entities.Basket;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class SaleDTO {

    private long id;

    private BigDecimal allCosts;

    private List<BasketDTO> baskets;
}
