package com.example.vehicleRental;


import static org.junit.jupiter.api.Assertions.*;

import com.vehicleRental.Customer;
import com.vehicleRental.Motorcycle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MotorcycleTest {

    private Motorcycle motorcycle;
    private Customer customer;

    @BeforeEach
    void setUp() {
        // Initialize objects before each test
        motorcycle = new Motorcycle("2", "Harley Davidson", 80.0); // motorcycle with base rental rate of 80
        customer = new Customer("Jane Doe", "67890XYZ");
    }

    @Test
    void testCalculateRentalCost() {
        // Test rental cost calculation (with 10% discount for motorcycles)
        double cost = motorcycle.calculateRentalCost(5); // 5 days rental
        assertEquals(360.0, cost); // Should match 80 * 5 * 0.9
    }

    @Test
    void testRent() {
        // Test renting the motorcycle
        motorcycle.rent(customer, 3); // Rent the motorcycle for 3 days
        assertFalse(motorcycle.isAvailable()); // The motorcycle should no longer be available after renting
    }

    @Test
    void testReturnVehicle() {
        // Test returning the motorcycle
        motorcycle.rent(customer, 3); // Rent the motorcycle first
        motorcycle.returnVehicle(); // Return the motorcycle
        assertTrue(motorcycle.isAvailable()); // The motorcycle should be available again after return
    }

    @Test
    void testRentWhenNotAvailable() {
    }
}
        // Test renting t

