package com.example.vehicleRental;

import static org.junit.jupiter.api.Assertions.*;

import com.vehicleRental.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        // Initialize the Customer object before each test
        customer = new Customer("John Smith", "12345ABC");
    }

    @Test
    void testGetName() {
        // Test if the getName() method works as expected
        assertEquals("John Smith", customer.getName());
    }

    @Test
    void testGetDriverLicenseNumber() {
        // Test if the getDriverLicenseNumber() method works as expected
        assertEquals("12345ABC", customer.getDriverLicenseNumber());
    }
}

