package com.example.springboot.model.entities;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long    id;

    String  username;

    String  password;

    Long    phoneNum;

    String  email;

}