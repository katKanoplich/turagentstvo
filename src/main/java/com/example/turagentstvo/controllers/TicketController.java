package com.example.turagentstvo.controllers;

import com.example.turagentstvo.entities.Ticket;
import com.example.turagentstvo.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Ticket> getTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ticket getTicketById(@PathVariable long id) {
        return ticketService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket addTicket(@RequestBody Ticket ticket) {
        return ticketService.addTicket(ticket);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delTicket(@PathVariable long id) {
        ticketService.deleteTicket(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ticket updateTicket(@PathVariable long id, @RequestBody Ticket ticket) {
        return ticketService.updateTicket(id, ticket);
    }

}
