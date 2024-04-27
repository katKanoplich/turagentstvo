package com.example.turagentstvo.controllers;
import com.example.turagentstvo.entities.Basket;
import com.example.turagentstvo.services.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Basket> getBaskets() {
        return basketService.getAllBaskets();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Basket getBasketById(@PathVariable long id) {
        return basketService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Basket addBasket(@RequestBody Basket basket) {
        return basketService.addBasket(basket);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delBasket(@PathVariable long id) {
        basketService.deleteBasket(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Basket updateBasket(@PathVariable long id, @RequestBody Basket basket) {
        return basketService.updateBasket(id, basket);
    }
}
