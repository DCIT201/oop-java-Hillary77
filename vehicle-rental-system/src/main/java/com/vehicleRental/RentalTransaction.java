package com.vehicleRental;

public class RentalTransaction {
    private Customer customer;
    private Vehicle vehicle;
    private int rentalDays;

    public RentalTransaction(Customer customer, Vehicle vehicle, int rentalDays) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
    }

    public void processRental() {
        vehicle.rent(customer, rentalDays);
    }

    public void processReturn() {
        vehicle.returnVehicle();
    }
}
