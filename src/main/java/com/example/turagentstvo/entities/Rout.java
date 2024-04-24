package com.example.turagentstvo.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "routs")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Rout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "start_point")
    private String startPoint;

    @Column(name = "finish_point")
    private String finishPoint;


}


