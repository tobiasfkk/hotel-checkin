package com.example.hotelcheckin.service;

import com.example.hotelcheckin.model.CheckIn;
import com.example.hotelcheckin.repository.CheckInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckInService {
    @Autowired
    private CheckInRepository checkInRepository;

    public CheckIn save(CheckIn checkIn) {
        return checkInRepository.save(checkIn);
    }

    public List<CheckIn> findAll() {
        return checkInRepository.findAll();
    }

    public List<CheckIn> findActive() {
        return checkInRepository.findByDataSaidaIsNull();
    }

    public List<CheckIn> findInactive() {
        return checkInRepository.findByDataSaidaIsNotNull();
    }
}