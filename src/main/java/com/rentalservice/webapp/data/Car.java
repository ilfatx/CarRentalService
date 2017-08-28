package com.rentalservice.webapp.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;


public class Car {

    @Id
    public String id;

    public String reg;
    @DBRef
    public CarBrand carBrand;

    public Car() {}

    public Car(String reg, CarBrand carBrand) {
        this.reg = reg;
        this.carBrand = carBrand;
    }

    @Override
    public String toString() {
        return String.format(
                "Car[id=%s, reg='%s', carBrand='%s']",
                id, reg, carBrand);
    }

}
