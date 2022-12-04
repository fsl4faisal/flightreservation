package com.flight.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Passenger extends AbstractEntity{
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    private String email;
    private String phone;
}
