package com.example.api.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Customer {
    private String dni;
    private String name;

    public Customer(String dni, String name) {
        this.dni = dni;
        this.name = name;
    }
}
