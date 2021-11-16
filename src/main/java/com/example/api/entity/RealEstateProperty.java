package com.example.api.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RealEstateProperty {
    private int code;
    private String address;
    private double amount;

    public RealEstateProperty(int code, String address, double amount) {
        this.code = code;
        this.address = address;
        this.amount = amount;
    }
}
