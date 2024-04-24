package com.example.turagentstvo.services;

import com.example.turagentstvo.entities.Rout;

import java.util.List;

public interface RoutService {
    List<Rout> getAllRouts();
    Rout addRout(Rout rout);
    void deleteRout(long id);
    Rout updateRout(long id, Rout updateRout);
    Rout getById(long id);
}
