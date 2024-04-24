package com.example.turagentstvo.services.impl;

import com.example.turagentstvo.entities.Ticket;
import com.example.turagentstvo.repositorys.TicketRepository;
import com.example.turagentstvo.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }
    public Ticket addTicket(Ticket ticket){
        ticketRepository.save(ticket);
        return ticket;
    }
    public void deleteTicket(long id) {
        ticketRepository.deleteById(id);
    }
    public Ticket updateTicket(long id, Ticket updateTicket) {
        updateTicket.setId(id);
        return ticketRepository.save(updateTicket);
    }
    public Ticket getById(long id){
        return ticketRepository.findById(id).orElseThrow();
    }
}
