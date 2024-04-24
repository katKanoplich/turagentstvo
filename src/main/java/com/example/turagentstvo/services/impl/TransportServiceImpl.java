package com.example.turagentstvo.services.impl;

import com.example.turagentstvo.entities.Transport;
import com.example.turagentstvo.repositorys.TransportRepository;
import com.example.turagentstvo.services.TransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransportServiceImpl implements TransportService {

    private final TransportRepository transportRepository;
    public List<Transport> getAllTransports(){
        return transportRepository.findAll();
    }
    public Transport addTransport(Transport transport){
        transportRepository.save(transport);
        return transport;
    }
    public void deleteTransport(long id) {
        transportRepository.deleteById(id);
    }
    public Transport updateTransport(long id, Transport updateTransport) {
        updateTransport.setId(id);
        return transportRepository.save(updateTransport);
    }
    public Transport getById(long id){
        return transportRepository.findById(id).orElseThrow();
    }
}
