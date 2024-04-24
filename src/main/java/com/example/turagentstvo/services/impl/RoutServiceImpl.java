package com.example.turagentstvo.services.impl;

import com.example.turagentstvo.entities.Rout;
import com.example.turagentstvo.repositorys.RoutRepository;
import com.example.turagentstvo.services.RoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoutServiceImpl implements RoutService {
    private final RoutRepository routRepository;
    public List<Rout> getAllRouts(){
        return routRepository.findAll();
    }
    public Rout addRout(Rout rout){
        routRepository.save(rout);
        return rout;
    }
    public void deleteRout(long id) {
        routRepository.deleteById(id);
    }
    public Rout updateRout(long id, Rout updateRout) {
        updateRout.setId(id);
        return routRepository.save(updateRout);
    }
    public Rout getById(long id){
        return routRepository.findById(id).orElseThrow();
    }
}
