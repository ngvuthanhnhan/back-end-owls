package com.example.springboot.model.entities;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long    id;

    Long    subjectId;

    Long    name;

    Long    description;

    Long    info;

}
