package com.example.CareConnect.repository;





import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository<Resident> extends JpaRepository<Resident, Long> {
}
