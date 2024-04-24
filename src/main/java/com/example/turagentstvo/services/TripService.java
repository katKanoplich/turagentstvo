package com.example.turagentstvo.services;

import com.example.turagentstvo.entities.Trip;

import java.util.List;

public interface TripService {
    List<Trip> getAllTrips();
    Trip addTrip(Trip trip);
    void deleteTrip(long id);
    Trip updateTrip(long id, Trip updateTrip);
    Trip getById(long id);
}
