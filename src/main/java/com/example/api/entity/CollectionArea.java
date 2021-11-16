package com.example.api.entity;

import java.util.Date;

public class CollectionArea {
    private int id;
    private Date date;
    private Customer customer;
    private RealEstateProperty property;

    public CollectionArea(int id, Date date, Customer customer, RealEstateProperty property) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.property = property;
    }
}
