package com.example.turagentstvo.services;

import com.example.turagentstvo.entities.Sale;

import java.util.List;

public interface SaleService {
    List<Sale> getAllSales();
    Sale addSale(Sale sale);
    void deleteSale(long id);
    Sale updateSale(long id, Sale updateSale);
    Sale getById(long id);
}
