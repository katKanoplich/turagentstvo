package com.example.turagentstvo.controllers;
import com.example.turagentstvo.entities.Trip;
import com.example.turagentstvo.services.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trip")
@RequiredArgsConstructor
public class TripController {

    private final TripService tripService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Trip> getTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Trip getTripById(@PathVariable long id) {
        return tripService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Trip addTrip(@RequestBody Trip trip) {
        return tripService.addTrip(trip);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delTrip(@PathVariable long id) {
        tripService.deleteTrip(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Trip updateTrip(@PathVariable long id,@RequestBody Trip trip) {
        return tripService.updateTrip(id, trip);
    }
    
}
