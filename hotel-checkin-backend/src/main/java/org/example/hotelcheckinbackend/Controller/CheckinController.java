package org.example.hotelcheckinbackend.Controller;

import org.example.hotelcheckinbackend.Model.Checkin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkins")
public class CheckinController {
    @Autowired
    private CheckinService checkinService;

    @PostMapping
    public Checkin create(@RequestBody Checkin checkin) {
        return checkinService.save(checkin);
    }

    @GetMapping
    public List<Checkin> getAll() {
        return checkinService.findAll();
    }

    @GetMapping("/active")
    public List<Checkin> getActive() {
        return checkinService.findActive();
    }

    @GetMapping("/inactive")
    public List<Checkin> getInactive() {
        return checkinService.findInactive();
    }
}