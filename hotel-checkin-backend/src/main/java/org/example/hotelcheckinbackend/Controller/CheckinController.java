package com.example.hotelcheckin.controller;

import com.example.hotelcheckin.model.CheckIn;
import com.example.hotelcheckin.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkins")
public class CheckInController {
    @Autowired
    private CheckInService checkInService;

    @PostMapping
    public CheckIn create(@RequestBody CheckIn checkIn) {
        return checkInService.save(checkIn);
    }

    @GetMapping
    public List<CheckIn> getAll() {
        return checkInService.findAll();
    }

    @GetMapping("/active")
    public List<CheckIn> getActive() {
        return checkInService.findActive();
    }

    @GetMapping("/inactive")
    public List<CheckIn> getInactive() {
        return checkInService.findInactive();
    }
}