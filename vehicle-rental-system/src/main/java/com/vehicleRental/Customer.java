package com.vehicleRental;

public class Customer {
    private String name;
    private String driverLicenseNumber;

    public Customer(String name, String driverLicenseNumber) {
        this.name = name;
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public String getName() {
        return name;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }
}
