package com.jalandhara.crud.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Classroom {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private int roomNo;
    private int floorNo;
}
