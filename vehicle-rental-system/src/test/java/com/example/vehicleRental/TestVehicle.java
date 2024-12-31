package com.example.vehicleRental;


import com.vehicleRental.Vehicle;

import static jdk.jfr.FlightRecorder.isAvailable;

public class TestVehicle extends Vehicle {

    public TestVehicle(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        // Just return the base rental rate for testing purposes
        return getBaseRentalRate() * days;
    }

    @Override
    public boolean isAvailableForRental() {
        // Simply return the availability status for testing
        return isAvailable();
    }

    public boolean isAvailable() {
        return false;
    }

    public String getVehicleId() {
        return "";
    }
}


