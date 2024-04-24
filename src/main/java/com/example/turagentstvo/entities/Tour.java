package com.example.turagentstvo.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Table(name = "tours")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "start_date")
    private ZonedDateTime starDate;

    @Column(name = "finish_date")
    private ZonedDateTime finishDate;

    @Column(name="price")
    private BigDecimal price;

    @Column(name="type")
    private String type;


}
