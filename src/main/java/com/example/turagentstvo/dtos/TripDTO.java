package com.example.turagentstvo.dtos;

import com.example.turagentstvo.entities.Transport;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.ZonedDateTime;
@Data
public class TripDTO {

    private long id;

    private ZonedDateTime date;

    private Transport transport;

}
