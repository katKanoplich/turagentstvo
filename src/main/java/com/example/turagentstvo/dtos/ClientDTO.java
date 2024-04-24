package com.example.turagentstvo.dtos;

import com.example.turagentstvo.entities.Auth;
import com.example.turagentstvo.entities.Basket;
import com.example.turagentstvo.entities.Ticket;
import lombok.Data;

import java.util.List;

@Data
public class ClientDTO {

    private long id;

    private String firstName;

    private String lastName;

    private  String patronymic;

    private  int age;

    private  String passportId;

    private  int passportNumber;

    private Basket basket;

    private Auth auth;

    private List<TicketDTO> tickets;
}
