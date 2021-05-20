package com.example.sqlserverpoc.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Patient
{
    private UUID patientId;
    private String firstName;
    private String lastName;

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid2", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(columnDefinition="uniqueidentifier")
    public UUID getPatientId()
    {
        return patientId;
    }

    public void setPatientId(UUID patientId)
    {
        this.patientId = patientId;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
}
