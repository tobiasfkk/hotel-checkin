package org.example.hotelcheckinbackend.Controller;

import org.example.hotelcheckinbackend.Repository.CheckinRepository;
import org.example.hotelcheckinbackend.Model.Checkin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class CheckinService {
    @Autowired
    private CheckinRepository checkinRepository;

    public Checkin save(Checkin checkin) {
        return checkinRepository.save(checkin);
    }

    public List<Checkin> findAll() {
        return checkinRepository.findAll();
    }

    public List<Checkin> findActive() {
        return checkinRepository.findByDataSaidaIsNull();
    }

    public List<Checkin> findInactive() {
        return checkinRepository.findByDataSaidaIsNotNull();
    }

    public Checkin findById(Long id) {
        return checkinRepository.findById(id).orElse(null);
    }

    public double calculateTotal(Checkin checkin) {
        LocalDateTime entrada = checkin.getDataEntrada();
        LocalDateTime saida = checkin.getDataSaida() != null ? checkin.getDataSaida() : LocalDateTime.now();
        long days = ChronoUnit.DAYS.between(entrada, saida);
        double total = 0;

        for (long i = 0; i <= days; i++) {
            LocalDateTime currentDay = entrada.plusDays(i);
            DayOfWeek dayOfWeek = currentDay.getDayOfWeek();
            boolean isWeekend = dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;

            total += isWeekend ? 150 : 120;
            if (checkin.isAdicionalVeiculo()) {
                total += isWeekend ? 20 : 15;
            }
        }

        if (saida.toLocalTime().isAfter(LocalTime.of(16, 30))) {
            total += saida.getDayOfWeek() == DayOfWeek.SATURDAY || saida.getDayOfWeek() == DayOfWeek.SUNDAY ? 150 : 120;
        }

        return total;
    }

}