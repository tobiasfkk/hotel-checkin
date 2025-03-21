package org.example.hotelcheckinbackend.Model;

import java.time.LocalDateTime;
import java.util.Objects;
import jakarta.persistence.*;

@Entity
public class Checkin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Person person;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private boolean adicionalVeiculo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    public boolean isAdicionalVeiculo() {
        return adicionalVeiculo;
    }

    public void setAdicionalVeiculo(boolean adicionalVeiculo) {
        this.adicionalVeiculo = adicionalVeiculo;
    }

    @Override
    public String toString() {
        return "Checkin{" +
                "id=" + id +
                ", person=" + person +
                ", dataEntrada=" + dataEntrada +
                ", dataSaida=" + dataSaida +
                ", adicionalVeiculo=" + adicionalVeiculo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checkin checkin = (Checkin) o;
        return adicionalVeiculo == checkin.adicionalVeiculo &&
                Objects.equals(id, checkin.id) &&
                Objects.equals(person, checkin.person) &&
                Objects.equals(dataEntrada, checkin.dataEntrada) &&
                Objects.equals(dataSaida, checkin.dataSaida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person, dataEntrada, dataSaida, adicionalVeiculo);
    }
}