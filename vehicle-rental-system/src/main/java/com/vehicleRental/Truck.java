package com.vehicleRental;

public class Truck extends Vehicle implements Rentable {
    public Truck(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days * 1.2; // 20% surcharge for trucks
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental()) {
            setAvailable(false);
            System.out.println("Truck rented to " + customer.getName() + " for " + days + " days.");
        } else {
            System.out.println("Truck is not available for rental.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Truck returned.");
    }
}
