package com.example.turagentstvo.controllers;

import com.example.turagentstvo.entities.Transport;
import com.example.turagentstvo.services.TransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transport")
@RequiredArgsConstructor
public class TransportController {

    private final TransportService transportService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Transport> getTransports() {
        return transportService.getAllTransports();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Transport getTransportById(@PathVariable long id) {
        return transportService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transport addTransport(@RequestBody Transport transport) {
        return transportService.addTransport(transport);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delTransport(@PathVariable long id) {
        transportService.deleteTransport(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Transport updateTransport(@PathVariable long id,@RequestBody  Transport transport) {
        return transportService.updateTransport(id, transport);
    }
}
