package com.rentalservice.webapp.data;
import org.springframework.data.annotation.Id;


public class CarBrand {

    @Id
    public String id;

    public String shortName;
    public String longName;
    public CarType carType;

    public CarBrand() {}

    public CarBrand(String shortName, String longName, CarType carType) {
        this.shortName = shortName;
        this.longName = longName;
        this.carType = carType;
    }

    @Override
    public String toString() {
        return String.format(
                "CarBrand[id=%s, shortName='%s', longName='%s', carType='%s']",
                id, shortName, longName, carType);
    }

}



