package com.example.vehicleRental;

import static org.junit.jupiter.api.Assertions.*;

import com.vehicleRental.Car;
import com.vehicleRental.Customer;
import com.vehicleRental.RentalAgency;
import com.vehicleRental.RentalTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RentalTransactionTest {

    private RentalAgency agency;
    private Customer customer;
    private Car car;
    private RentalTransaction rentalTransaction;

    @BeforeEach
    void setUp() {
        // Set up the rental agency and customer
        agency = new RentalAgency();
        customer = new Customer("John Doe", "DL12345");

        // Create and add vehicles
        car = new Car("C123", "Toyota Corolla", 50);
        agency.addVehicle(car);

        // Create the rental transaction
        rentalTransaction = new RentalTransaction(customer, car, 5); // Rent for 5 days
    }

    @Test
    void testProcessRental() {
        // Initially, the car should be available for rental
        assertTrue(car.isAvailable());

        // Process the rental
        rentalTransaction.processRental();

        // After rental, the car should be unavailable
        assertFalse(car.isAvailable());
    }

    @Test
    void testProcessReturn() {
        // First, rent the car
        rentalTransaction.processRental();
        assertFalse(car.isAvailable());

        // Now return the vehicle
        rentalTransaction.processReturn();

        // After return, the car should be available again
        assertTrue(car.isAvailable());
    }
}

