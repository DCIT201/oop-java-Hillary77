package com.example;

import com.vehicleRental.*;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

                // Create some vehicles
                Vehicle car = new Car("C123", "Toyota Camry", 50.0);
                Vehicle motorcycle = new Motorcycle("M456", "Harley Davidson", 30.0);
                Vehicle truck = new Truck("T789", "Ford F-150", 80.0);

                // Create rental agency
                RentalAgency rentalAgency = new RentalAgency();
                rentalAgency.addVehicle(car);
                rentalAgency.addVehicle(motorcycle);
                rentalAgency.addVehicle(truck);

                // Create a customer
                Customer customer = new Customer("John Doe", "A1234567");

                // Rent a car for 5 days
                System.out.println("Renting a car...");
                Vehicle availableCar = rentalAgency.findAvailableVehicle(Car.class);
                if (availableCar != null) {
                    availableCar.rent(customer, 5);
                } else {
                    System.out.println("No available car for rental.");
                }

                // Rent a motorcycle for 3 days
                System.out.println("\nRenting a motorcycle...");
                Vehicle availableMotorcycle = rentalAgency.findAvailableVehicle(Motorcycle.class);
                if (availableMotorcycle != null) {
                    availableMotorcycle.rent(customer, 3);
                } else {
                    System.out.println("No available motorcycle for rental.");
                }

                // Return the motorcycle
                System.out.println("\nReturning the motorcycle...");
                if (availableMotorcycle != null) {
                    availableMotorcycle.returnVehicle();
                }

                // Try renting a truck for 7 days
                System.out.println("\nRenting a truck...");
                Vehicle availableTruck = rentalAgency.findAvailableVehicle(Truck.class);
                if (availableTruck != null) {
                    availableTruck.rent(customer, 7);
                } else {
                    System.out.println("No available truck for rental.");
                }

                // Return the truck
                System.out.println("\nReturning the truck...");
                if (availableTruck != null) {
                    availableTruck.returnVehicle();
                }
            }
        }

