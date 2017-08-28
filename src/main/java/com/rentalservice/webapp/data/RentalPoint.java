package com.rentalservice.webapp.data;
import org.springframework.data.annotation.Id;


public class RentalPoint {

    @Id
    public String id;

    public String shortName;
    public String longName;

    public RentalPoint() {}

    public RentalPoint(String shortName, String longName) {
        this.shortName = shortName;
        this.longName = longName;
    }

    @Override
    public String toString() {
        return String.format(
                "RentalPoint[id=%s, shortName='%s', longName='%s']",
                id, shortName, longName);
    }

}
