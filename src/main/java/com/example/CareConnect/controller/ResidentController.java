package com.example.CareConnect.controller;

import com.example.CareConnect.model.Resident;
import com.example.CareConnect.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/residents")
@CrossOrigin(origins = "http://localhost:3000")
public class ResidentController {

    @Autowired
    private ResidentService service;

    @PostMapping
    public Resident addResident(@RequestBody Resident resident) {
        return service.addResident(resident);
    }

    @GetMapping
    public List<Resident> getAllResidents() {
        return service.getAllResidents();
    }

    @GetMapping("/{id}")
    public Resident getResident(@PathVariable Long id) throws Throwable {
        return service.getResidentById(id);
    }

    @PutMapping("/{id}")
    public Resident updateResident(@PathVariable Long id, @RequestBody Resident updated) throws Throwable {
        return service.updateResident(id, updated);
    }

    @DeleteMapping("/{id}")
    public String deleteResident(@PathVariable Long id) {
        service.deleteResident(id);
        return "Resident deleted successfully!";
    }
}
