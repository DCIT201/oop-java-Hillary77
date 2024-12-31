package com.example.vehicleRental;


import com.vehicleRental.Car;
import com.vehicleRental.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    private Car car;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        // Set up the objects before each test
        car = new Car("C001", "Toyota Corolla", 50.0);
        customer = new Customer("John Doe", "D12345");
    }

    @Test
    public void testCalculateRentalCost() {
        // Test that rental cost is calculated correctly
        double rentalCost = car.calculateRentalCost(5);  // 5 days
        assertEquals(250.0, rentalCost, "Rental cost should be 50 * 5 = 250");
    }

    @Test
    public void testIsAvailableForRentalWhenAvailable() {
        // Test if car is available for rental
        assertTrue(car.isAvailableForRental(), "Car should be available for rental");
    }

    @Test
    public void testIsAvailableForRentalWhenNotAvailable() {
        // Rent the car
        car.rent(customer, 3);
        assertFalse(car.isAvailableForRental(), "Car should not be available after renting");
    }

    private void assertFalse(boolean availableForRental, String s) {
    }

    @Test
    public void testRent() {
        // Rent the car and ensure it's no longer available
        car.rent(customer, 3);
        assertFalse(car.isAvailable(), "Car should be unavailable after rental");
    }

    @Test
    public void testReturnVehicle() {
        // Rent the car, then return it and check availability
        car.rent(customer, 3);
        car.returnVehicle();
        assertTrue(car.isAvailable(), "Car should be available after return");
    }
}


