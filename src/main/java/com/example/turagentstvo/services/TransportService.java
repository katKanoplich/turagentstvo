package com.example.turagentstvo.services;

import com.example.turagentstvo.entities.Transport;

import java.util.List;

public interface TransportService {
    List<Transport> getAllTransports();
    Transport addTransport(Transport transport);
    void deleteTransport(long id);
    Transport updateTransport(long id, Transport updateTransport);
    Transport getById(long id);
}
