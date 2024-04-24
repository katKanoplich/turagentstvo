package com.example.turagentstvo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;

@Entity
@Table(name = "trips")
@Data
@AllArgsConstructor
@RequiredArgsConstructor

public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date")
    private ZonedDateTime date;

    @ManyToOne
    @JoinColumn(name = "rout_id")
    private Rout rout;

    @ManyToOne
    @JoinColumn(name = "transport_id")
    private Transport transport;

}
