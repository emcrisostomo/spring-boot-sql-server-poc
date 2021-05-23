package com.example.sqlserverpoc.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
public class EntityId implements Serializable
{
    private UUID uniqueId;

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid2", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(columnDefinition = "uniqueidentifier")
    public UUID getUniqueId()
    {
        return uniqueId;
    }

    public void setUniqueId(UUID uniqueId)
    {
        this.uniqueId = uniqueId;
    }
}
