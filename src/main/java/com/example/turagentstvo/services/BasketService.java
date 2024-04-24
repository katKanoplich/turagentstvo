package com.example.turagentstvo.services;

import com.example.turagentstvo.entities.Basket;

import java.util.List;

public interface BasketService {
    List<Basket> getAllBaskets();
    Basket addBasket(Basket basket);
    void deleteBasket(long id);
    Basket updateBasket(long id, Basket updateBasket);
    Basket getById(long id);
}
