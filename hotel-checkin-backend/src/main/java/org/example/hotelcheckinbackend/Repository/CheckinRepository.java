package com.example.hotelcheckin.repository;

import com.example.hotelcheckin.model.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
    List<CheckIn> findByDataSaidaIsNull();
    List<CheckIn> findByDataSaidaIsNotNull();
}