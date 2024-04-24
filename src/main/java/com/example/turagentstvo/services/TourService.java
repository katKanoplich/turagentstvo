package com.example.turagentstvo.services;

import com.example.turagentstvo.entities.Tour;

import java.util.List;

public interface TourService {
    List<Tour> getAllTours();
    Tour addTour(Tour tour);
    void deleteTour(long id);
    Tour updateTour(long id, Tour updateTour);
    Tour getById(long id);
}
