package org.example.hotelcheckinbackend.Repository;

import org.example.hotelcheckinbackend.Model.Checkin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckinRepository extends JpaRepository<Checkin, Long> {
    List<Checkin> findByDataSaidaIsNull();
    List<Checkin> findByDataSaidaIsNotNull();
}