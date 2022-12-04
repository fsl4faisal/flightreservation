package com.flight.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class User extends AbstractEntity {
    @Column(name = "first_name")
    @Size(min = 5)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String password;
}
