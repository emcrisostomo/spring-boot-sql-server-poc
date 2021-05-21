package com.example.sqlserverpoc.controllers;

import com.example.sqlserverpoc.entities.Patient;
import com.example.sqlserverpoc.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.UUID;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

@RestController
public class PatientApi
{
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients/{patientId}")
    public ResponseEntity<Patient> getPatient(@PathVariable String patientId)
    {
        UUID uuid;

        try
        {
            uuid = UUID.fromString(patientId);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }

        return patientRepository
                .findById(uuid)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> searchPatients(@RequestParam(required = false) String firstName)
    {
        return ResponseEntity
                .ok(patientRepository
                        .findByFirstName(firstName));
    }

    @PostMapping("/patients")
    public ResponseEntity<Void> postPatient(@RequestBody Patient patient)
    {
        patientRepository.save(patient);

        return ResponseEntity
                .created(
                        MvcUriComponentsBuilder
                                .fromMethodCall(on(PatientApi.class).getPatient(patient.getPatientId().toString()))
                                .build()
                                .toUri())
                .build();
    }
}
