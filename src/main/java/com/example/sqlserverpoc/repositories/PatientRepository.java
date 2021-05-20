package com.example.sqlserverpoc.repositories;

import com.example.sqlserverpoc.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID>
{
    List<Patient> findByFirstName(String firstName);
}
