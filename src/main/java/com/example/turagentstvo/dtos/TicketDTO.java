package com.example.turagentstvo.dtos;

import com.example.turagentstvo.entities.Client;
import com.example.turagentstvo.entities.Tour;
import com.example.turagentstvo.entities.Trip;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class TicketDTO {

    private long id;

    private BigDecimal totalPrice;

    private String ticketStatus;

    private Tour tour;

    private Trip trip;

    private Client client;
}
