package com.example.turagentstvo.services.impl;

import com.example.turagentstvo.entities.Sale;
import com.example.turagentstvo.repositorys.SaleRepository;
import com.example.turagentstvo.services.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    public List<Sale> getAllSales(){
        return saleRepository.findAll();
    }
    public Sale addSale(Sale sale){
        saleRepository.save(sale);
        return sale;
    }
    public void deleteSale(long id) {
        saleRepository.deleteById(id);
    }
    public Sale updateSale(long id, Sale updateSale) {
        updateSale.setId(id);
        return saleRepository.save(updateSale);
    }
    public Sale getById(long id){
        return saleRepository.findById(id).orElseThrow();
    }
    
}
