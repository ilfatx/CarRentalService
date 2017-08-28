package com.rentalservice.webapp.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;


public class RentalService {

    @Id
    public String id;

    public Car car;
    @DBRef
    public RentalPoint inRentalService;
    @DBRef
    public RentalPoint outRentalService;
    public Date  inTime;
    public Date outTime;
    public String userName;


    public RentalService() {}

    public RentalService(Car car, RentalPoint inRentalService, RentalPoint outRentalService, Date inTime, Date outTime, String userName) {
        this.car = car;
        this.inRentalService = inRentalService;
        this.outRentalService = outRentalService;
        this.inTime = inTime;
        this.outTime = outTime;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return String.format(
                "RentalService[id=%s, car=%s, inRentalService=%s, outRentalService=%s, inTime=%s, outTime=%s, userName=%s]",
                id, car,  inRentalService,  outRentalService,  inTime,  outTime,  userName);
    }

}