package com.rentalservice.webapp.data;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class RentalServiceDTO {

    private CarType carType;
    private String carBrandName;
    private String carReg;
    private String inRentalServiceName;
    private String outRentalServiceName;
    private Date inTime;
    private Date outTime;
    private String userName;


    public RentalServiceDTO() {}

    public RentalServiceDTO(Car car, RentalPoint inRentalService, RentalPoint outRentalService, Date inTime, Date outTime, String userName) {
        this.carType = car.carBrand.carType;
        this.carBrandName = car.carBrand.longName;
        this.carReg = car.reg;
        this.inRentalServiceName = inRentalService.longName;
        this.outRentalServiceName = outRentalService.longName;
        this.inTime = inTime;
        this.outTime = outTime;
        this.userName = userName;
    }

    public RentalServiceDTO(RentalService rentalService) {
        this.carType = rentalService.car.carBrand.carType;
        this.carBrandName = rentalService.car.carBrand.longName;
        this.carReg = rentalService.car.reg;
        this.inRentalServiceName = rentalService.inRentalService.longName;
        this.outRentalServiceName = rentalService.outRentalService.longName;
        this.inTime = rentalService.inTime;
        this.outTime = rentalService.outTime;
        this.userName = rentalService.userName;
    }

    @Override
    public String toString() {
        return String.format(
                "RentalService[car=%s, inRentalService=%s, outRentalService=%s, inTime=%s, outTime=%s, userName=%s]",
                carReg,  inRentalServiceName,  outRentalServiceName,  inTime,  outTime,  userName);
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getCarBrandName() {
        return carBrandName;
    }

    public void setCarBrandName(String carBrandName) {
        this.carBrandName = carBrandName;
    }

    public String getCarReg() {
        return carReg;
    }

    public void setCarReg(String carReg) {
        this.carReg = carReg;
    }

    public String getInRentalServiceName() {
        return inRentalServiceName;
    }

    public void setInRentalServiceName(String inRentalServiceName) {
        this.inRentalServiceName = inRentalServiceName;
    }

    public String getOutRentalServiceName() {
        return outRentalServiceName;
    }

    public void setOutRentalServiceName(String outRentalServiceName) {
        this.outRentalServiceName = outRentalServiceName;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
