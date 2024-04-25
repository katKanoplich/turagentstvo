package com.example.turagentstvo.controllers;
import com.example.turagentstvo.entities.Sale;
import com.example.turagentstvo.services.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Sale> getSales() {
        return saleService.getAllSales();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Sale getSaleById(@PathVariable long id) {
        return saleService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sale addSale(@RequestBody Sale sale) {
        return saleService.addSale(sale);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delSale(@PathVariable long id) {
        saleService.deleteSale(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Sale updateSale(@PathVariable long id, @RequestBody Sale sale) {
        return saleService.updateSale(id, sale);
    }
}
