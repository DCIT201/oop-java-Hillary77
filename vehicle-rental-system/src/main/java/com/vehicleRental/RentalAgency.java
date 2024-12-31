package com.vehicleRental;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<Vehicle> vehicles;

    public RentalAgency() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public Vehicle findAvailableVehicle(Class<? extends Vehicle> vehicleType) {
        for (Vehicle vehicle : vehicles) {
            if (vehicleType.isInstance(vehicle) && vehicle.isAvailableForRental()) {
                return vehicle;
            }
        }
        return null;
    }

    public short addVehicle() {


        return 0;
    }}