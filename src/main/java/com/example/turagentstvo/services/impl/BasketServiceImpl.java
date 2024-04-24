package com.example.turagentstvo.services.impl;

import com.example.turagentstvo.entities.Basket;
import com.example.turagentstvo.repositorys.BasketRepository;
import com.example.turagentstvo.services.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;
    public List<Basket> getAllBaskets(){
        return basketRepository.findAll();
    }
    public Basket addBasket(Basket basket){
        basketRepository.save(basket);
        return basket;
    }
    public void deleteBasket(long id) {
        basketRepository.deleteById(id);
    }
    public Basket updateBasket(long id, Basket updateBasket) {
        updateBasket.setId(id);
        return basketRepository.save(updateBasket);
    }
    public Basket getById(long id){
        return basketRepository.findById(id).orElseThrow();
    }
}
