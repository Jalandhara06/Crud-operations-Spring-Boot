package com.jalandhara.crud.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;

    @JsonProperty("mobile_number")
    @Column(name = "mobile_number")
    private long mobileNumber;
    @Column(name = "age", columnDefinition = "age default 18")
    private int age;
}
