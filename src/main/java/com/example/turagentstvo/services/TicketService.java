package com.example.turagentstvo.services;

import com.example.turagentstvo.entities.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> getAllTickets();
    Ticket addTicket(Ticket ticket);
    void deleteTicket(long id);
    Ticket updateTicket(long id, Ticket updateTicket);
    Ticket getById(long id);
}
