package com.example.vehicleRental;

import static org.junit.jupiter.api.Assertions.*;

import com.vehicleRental.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RentalAgencyTest {

    private RentalAgency agency;
    private Car car;
    private Motorcycle motorcycle;
    private Truck truck;

    @BeforeEach
    void setUp() {
        // Set up the rental agency
        agency = new RentalAgency();

        // Create vehicles
        car = new Car("C123", "Toyota Corolla", 50);
        motorcycle = new Motorcycle("M456", "Harley Davidson", 30);
        truck = new Truck("T789", "Ford F-150", 80);

        // Add vehicles to the agency
        agency.addVehicle(car);
        agency.addVehicle(motorcycle);
        agency.addVehicle(truck);
    }

    @Test
    void testAddVehicle() {
        // Ensure the vehicles are added to the agency
        assertEquals(3, agency.addVehicle()); // We should have 3 vehicles added
    }

    @Test
    void testFindAvailableVehicle() {
        // Set the motorcycle as unavailable
        motorcycle.setAvailable(false);

        // Try to find an available car
        Vehicle availableCar = agency.findAvailableVehicle(Car.class);
        assertNotNull(availableCar);
        assertTrue(availableCar instanceof Car);

        // Try to find an available motorcycle (it should be unavailable)
        Vehicle availableMotorcycle = agency.findAvailableVehicle(Motorcycle.class);
        assertNull(availableMotorcycle);

        // Try to find an available truck
        Vehicle availableTruck = agency.findAvailableVehicle(Truck.class);
        assertNotNull(availableTruck);
        assertTrue(availableTruck instanceof Truck);
    }

    @Test
    void testFindNoAvailableVehicle() {
        // Set all vehicles as unavailable
        car.setAvailable(false);
        motorcycle.setAvailable(false);
        truck.setAvailable(false);

        // Try to find any available vehicle, it should return null
        Vehicle availableVehicle = agency.findAvailableVehicle(Car.class);
        assertNull(availableVehicle);
    }
}
