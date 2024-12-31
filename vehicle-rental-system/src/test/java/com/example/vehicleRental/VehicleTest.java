package com.example.vehicleRental;

import static org.junit.jupiter.api.Assertions.*;

import com.vehicleRental.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VehicleTest {

    private TestVehicle vehicle;

    @BeforeEach
    void setUp() {
        // Create a new TestVehicle object with base rental rate of 100
        vehicle = new TestVehicle("V123", "Sedan", 100);
    }

    @Test
    void testVehicleInitialState() {
        // Ensure the vehicle is available by default
        assertTrue(vehicle.isAvailable());

        // Ensure vehicle details are correct
        assertEquals("V123", vehicle.getVehicleId());
        assertEquals("Sedan", vehicle.getModel());
        assertEquals(100, vehicle.getBaseRentalRate());
    }

    @Test
    void testCalculateRentalCost() {
        // Rent for 5 days
        double cost = vehicle.calculateRentalCost(5);

        // The rental cost should be 100 (base rate) * 5 days = 500
        assertEquals(500, cost);
    }

    @Test
    void testRentVehicle() {
        // Ensure the vehicle is available before renting
        assertTrue(vehicle.isAvailable());

        // Rent the vehicle for 3 days
        vehicle.rent(new Customer("John", "DL123"), 3);

        // After renting, the vehicle should no longer be available
        assertFalse(vehicle.isAvailable());
    }

    @Test
    void testReturnVehicle() {
        // Rent the vehicle first
        vehicle.rent(new Customer("John", "DL123"), 3);

        // After renting, the vehicle should not be available
        assertFalse(vehicle.isAvailable());

        // Return the vehicle
        vehicle.returnVehicle();

        // After returning, the vehicle should be available again
        assertTrue(vehicle.isAvailable());
    }
}


