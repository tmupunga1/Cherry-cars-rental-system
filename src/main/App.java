package main;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private static CherryCars company = new CherryCars();
    private static Customer customer = new Customer("123ABC");
    private static Scanner kybd = new Scanner(System.in);

    public static void main(String[] args) {

        populateVehicles();

        int choice;
        do {
            displayMenu();
            choice = getUserChoice();
            processChoice(choice);
        } while (choice != -1);

        kybd.close();
    }

    
    private static void populateVehicles() {

    ArrayList<Vehicle> vehicles =
        DatabaseHelper.fetchVehicles();

    int x = 0;

    for (Vehicle veh : vehicles) {

        x++;

        if (veh != null) {

            if (company.findVehicle(veh.getRegNumber()) == null) {

                company.addVehicle(veh);

            } else {

                System.out.println(
                    veh.getRegNumber() +
                    " is a duplicate so not added"
                );
            }

        } else {

            System.out.println(
                "Problem adding vehicle " + x
            );
        }
    }
}

   
    private static void viewVehicles() {
        ArrayList<Vehicle> vehicles = company.getVehicles();

        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available");
        } else {
            System.out.println("All vehicles:");
            for (Vehicle veh : vehicles) {
                System.out.println(veh);
            }
        }
    }

    
    private static void viewAvailableVehicles() {
        ArrayList<Vehicle> vehicles = company.getAvailableVehicles();

        if (vehicles.isEmpty()) {
            System.out.println("No available vehicles");
        } else {
            System.out.println("Available vehicles:");
            for (Vehicle veh : vehicles) {
                System.out.println(veh);
            }
        }
    }

   
    private static void displayMenu() {
        System.out.println("\nCherry Cars Menu:");
        System.out.println("1. Rent a vehicle");
        System.out.println("2. Return a vehicle");
        System.out.println("3. View all vehicles");
        System.out.println("4. View available vehicles");
        System.out.println("5. View current rentals");
        System.out.println("6. View previous rentals");
        System.out.println("-1. Exit");
        System.out.print("Enter your choice: ");
    }

   
    private static int getUserChoice() {
        int choice = kybd.nextInt();
        kybd.nextLine(); // flush buffer
        return choice;
    }

   
    private static void processChoice(int choice) {
        switch (choice) {

            case 1:
                rentVehicle();
                break;

            case 2:
                returnVehicle();
                break;

            case 3:
                viewVehicles();
                break;

            case 4:
                viewAvailableVehicles();
                break;

            case 5:
                viewCurrentRentals();
                break;

            case 6:
                viewPreviousRentals();
                break;

            case -1:
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

  
    private static void rentVehicle() {
        System.out.print("Enter registration number: ");
        String reg = kybd.nextLine();

        Vehicle veh = company.findVehicle(reg);

        if (veh != null && customer.rentVehicle(veh)) {
            System.out.println(reg + " successfully rented");
        } else {
            System.out.println(reg + " doesn't exist or is already rented");
        }
    }

    private static void returnVehicle() {
        System.out.print("Enter registration number: ");
        String reg = kybd.nextLine();

        Vehicle veh = company.findVehicle(reg);

        if (veh != null && customer.returnVehicle(veh)) {
            System.out.println(reg + " successfully returned");
        } else {
            System.out.println(reg + " not found in your rentals");
        }
    }

   
    private static void viewCurrentRentals() {
        ArrayList<Vehicle> vehicles = customer.getCurrentRentals();

        if (vehicles.isEmpty()) {
            System.out.println("No current rentals");
        } else {
            System.out.println("Current rentals:");
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
        }
    }

    private static void viewPreviousRentals() {
        ArrayList<Vehicle> vehicles = customer.getPreviousRentals();

        if (vehicles.isEmpty()) {
            System.out.println("No previous rentals");
        } else {
            System.out.println("Previous rentals:");
            for (Vehicle veh : vehicles) {
                System.out.println(veh);
            }
        }
    }
}
