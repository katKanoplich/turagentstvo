package com.example.turagentstvo.services.impl;

import com.example.turagentstvo.entities.Tour;
import com.example.turagentstvo.repositorys.TourRepository;
import com.example.turagentstvo.services.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourServiceImpl implements TourService {
    private final TourRepository tourRepository;
    public List<Tour> getAllTours(){
        return tourRepository.findAll();
    }
    public Tour addTour(Tour tour){
        tourRepository.save(tour);
        return tour;
    }
    public void deleteTour(long id) {
        tourRepository.deleteById(id);
    }
    public Tour updateTour(long id, Tour updateTour) {
        updateTour.setId(id);
        return tourRepository.save(updateTour);
    }
    public Tour getById(long id){
        return tourRepository.findById(id).orElseThrow();
    }
}
