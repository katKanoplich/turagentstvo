package com.example.turagentstvo.controllers;

import com.example.turagentstvo.entities.Tour;
import com.example.turagentstvo.services.TourService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/tour")
@RequiredArgsConstructor
public class TourController {

    private final TourService tourService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Tour> getTours() {
        return tourService.getAllTours();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tour getTourById(@PathVariable long id) {
        return tourService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tour addTour(@RequestBody Tour tour) {
        return tourService.addTour(tour);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delTour(@PathVariable long id) {
        tourService.deleteTour(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tour updateTour(@PathVariable long id, @RequestBody Tour tour) {
        return tourService.updateTour(id, tour);
    }
}
