package com.example.turagentstvo.services.impl;

import com.example.turagentstvo.entities.Trip;
import com.example.turagentstvo.repositorys.TripRepository;
import com.example.turagentstvo.services.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;
    public List<Trip> getAllTrips(){
        return tripRepository.findAll();
    }
    public Trip addTrip(Trip trip){
        tripRepository.save(trip);
        return trip;
    }
    public void deleteTrip(long id) {
        tripRepository.deleteById(id);
    }
    public Trip updateTrip(long id, Trip updateTrip) {
        updateTrip.setId(id);
        return tripRepository.save(updateTrip);
    }
    public Trip getById(long id){
        return tripRepository.findById(id).orElseThrow();
    }
}
