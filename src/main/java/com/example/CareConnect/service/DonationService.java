package com.example.CareConnect.service;

import com.example.CareConnect.model.Donation;
import com.example.CareConnect.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DonationService {

    @Autowired
    private DonationRepository repo;

    public Donation save(Donation donation) {
        return (Donation) repo.save(donation);
    }

    public List<Donation> getAll() {
        return repo.findAll();
    }
}
