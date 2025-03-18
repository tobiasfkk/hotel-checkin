package org.example.hotelcheckinbackend.Controller;

import org.example.hotelcheckinbackend.Repository.CheckinRepository;
import org.example.hotelcheckinbackend.Model.Checkin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}