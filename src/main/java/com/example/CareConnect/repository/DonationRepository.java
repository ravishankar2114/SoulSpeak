package com.example.CareConnect.repository;



import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository<Donation> extends JpaRepository<Donation, Long> {}

