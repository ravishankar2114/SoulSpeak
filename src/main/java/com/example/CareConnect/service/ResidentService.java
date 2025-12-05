package com.example.CareConnect.service;

import com.example.CareConnect.model.Resident;
import com.example.CareConnect.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidentService {

    @Autowired
    private ResidentRepository repo;

    public Resident addResident(Resident resident) {
        return (Resident) repo.save(resident);
    }

    public List<Resident> getAllResidents() {
        return repo.findAll();
    }

    public Resident getResidentById(Long id) throws Throwable {
        return (Resident) repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Resident not found with ID: " + id));
    }

    public Resident updateResident(Long id, Resident updatedData) throws Throwable {
        Resident existing = (Resident) repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Resident not found with ID: " + id));

        existing.setName(updatedData.getName());
        existing.setAge(updatedData.getAge());
        existing.setRoomNumber(updatedData.getRoomNumber());
        existing.setGuardianName(updatedData.getGuardianName());
        existing.setGuardianContact(updatedData.getGuardianContact());

        return (Resident) repo.save(existing);
    }

    public void deleteResident(Long id) {
        repo.deleteById(id);
    }
}
