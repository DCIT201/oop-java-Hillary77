package com.example.vehicleRental;

import static org.junit.jupiter.api.Assertions.*;

import com.vehicleRental.Car;
import com.vehicleRental.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RentableTest {

    private Car car;
    private Customer customer;

    @BeforeEach
    void setUp() {
        // Create a new Customer object
        customer = new Customer("John Smith", "D12345");

        // Create a Car object
        car = new Car("123", "Sedan", 50);
    }

    @Test
    void testRentCar() {
        // Before renting, the car should be available
        assertTrue(car.isAvailable());

        // Rent the car
        car.rent(customer, 5);

        // After renting, the car should not be available
        assertFalse(car.isAvailable());
    }

    @Test
    void testReturnCar() {
        // Rent the car first
        car.rent(customer, 5);

        // Now return the car
        car.returnVehicle();

        // After returning, the car should be available again
        assertTrue(car.isAvailable());
    }

    @Test
    void testCalculateRentalCost() {
        // Rent the car for 5 days
        double cost = car.calculateRentalCost(5);

        // The rental cost should be 5 days * 50 per day
        assertEquals(250, cost);
    }
}





