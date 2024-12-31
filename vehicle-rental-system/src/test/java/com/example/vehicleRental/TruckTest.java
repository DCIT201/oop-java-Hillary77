package com.example.vehicleRental;

import static org.junit.jupiter.api.Assertions.*;

import com.vehicleRental.Customer;
import com.vehicleRental.Truck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TruckTest {

    private Truck truck;
    private Customer customer;

    @BeforeEach
    void setUp() {
        // Initialize objects before each test
        truck = new Truck("3", "Ford F-150", 100.0); // truck with base rental rate of 100
        customer = new Customer("John Smith", "12345ABC");
    }

    @Test
    void testCalculateRentalCost() {
        // Test rental cost calculation (with 20% surcharge for trucks)
        double cost = truck.calculateRentalCost(5); // 5 days rental
        assertEquals(600.0, cost); // Should match 100 * 5 * 1.2
    }

    @Test
    void testRent() {
        // Test renting the truck
        truck.rent(customer, 3); // Rent the truck for 3 days
        assertFalse(truck.isAvailable()); // The truck should no longer be available after renting
    }

    @Test
    void testReturnVehicle() {
        // Test returning the truck
        truck.rent(customer, 3); // Rent the truck first
        truck.returnVehicle(); // Return the truck
        assertTrue(truck.isAvailable()); // The truck should be available again after return
    }

    @Test
    void testRentWhenNotAvailable() {
        // Test renting the truck when it is not available
        truck.rent(customer, 3); // Rent the truck for 3 days
        truck.rent(customer, 2); // Try to rent it again (should be unavailable)
        assertFalse(truck.isAvailable()); // The truck should still be unavailable
    }
}
