package com.example.CareConnect.controller;

import com.example.CareConnect.model.Donation;
import com.example.CareConnect.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donations")
@CrossOrigin(origins = "http://localhost:3000")
public class DonationController {

    @Autowired
    private DonationService service;

    @PostMapping
    public Donation createDonation(@RequestBody Donation donation) {
        return service.save(donation);
    }

    @GetMapping
    public List<Donation> getAllDonations() {
        return service.getAll();
    }
}
