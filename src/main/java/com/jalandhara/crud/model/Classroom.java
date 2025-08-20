package com.jalandhara.crud.model;

public class Classroom {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private int roomNo;
    private int floorNo;
}
