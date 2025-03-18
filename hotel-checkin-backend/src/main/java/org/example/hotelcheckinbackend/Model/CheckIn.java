package com.example.hotelcheckin.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class CheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Person person;

    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private boolean adicionalVeiculo;
}