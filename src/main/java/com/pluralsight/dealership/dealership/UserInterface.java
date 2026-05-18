package com.pluralsight.dealership.dealership;

import com.pluralsight.dealership.contract.SalesContract;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private com.pluralsight.dealership.dealership.Dealership dealership = null;

    public UserInterface() {
    }

    public void display() {
        init();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to my Dealership");
            System.out.println("-----------------------");
            System.out.println("Choose an option:");
            System.out.println("1) Get Vehicles by Price");
            System.out.println("2) Get Vehicles by Make and Model");
            System.out.println("3) Get Vehicles by Year");
            System.out.println("4) Get Vehicles by Color");
            System.out.println("5) Get Vehicles by mileage");
            System.out.println("6) Get Vehicles by type");
            System.out.println("7) Get All Vehicles");
            System.out.println("8) contract menu");
            System.out.println("9) quit");
            System.out.println("-----------------------");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "1" -> processGetByPriceRequest(scanner);
                case "2" -> processGetByMakeModelRequest(scanner);
                case "3" -> processGetByYearRequest(scanner);
                case "4" -> processGetByColorRequest(scanner);
                case "5" -> processGetByMileageRequest(scanner);
                case "6" -> processGetByVehicleTypeRequest(scanner);
                case "7" -> processAllVehiclesRequest();
                case "8" -> contractMenu(scanner);
                case "9" -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
        scanner.close();
    }

    public void processGetByPriceRequest(Scanner scanner) {
        System.out.println("Enter your minimum amount: ");
        double minPrice;
        while (true) {
            if (scanner.hasNextDouble()) {
                minPrice = scanner.nextDouble();
                if (minPrice > 0) {
                    break;
                } else {
                    System.out.println("Enter a number greater than 0: ");
                }
            } else {
                scanner.nextLine();
                System.out.println("Enter a number: ");
            }
        }

        System.out.println("Enter your maximum amount: ");
        double maxPrice;
        while (true) {
            if (scanner.hasNextDouble()) {
                maxPrice = scanner.nextDouble();
                if (maxPrice > minPrice) {
                    break;
                } else {
                    System.out.println("Enter a number bigger than your minimum (" + minPrice + "): ");
                }
            } else {
                scanner.nextLine();
                System.out.println("Enter a number: ");
            }
        }
        displayVehicles(dealership.getVehiclesByPrice(minPrice, maxPrice));
        scanner.nextLine();
    }

    public void processGetByMakeModelRequest(Scanner scanner) {
        System.out.println("enter your car make: ");
        String make = scanner.nextLine().trim();

        System.out.println("enter your car model: ");
        String model = scanner.nextLine().trim();

        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    public void processGetByYearRequest(Scanner scanner) {
        System.out.println("enter your minimum year: ");
        int minYear;
        while (true) {
            if (scanner.hasNextInt()) {
                minYear = scanner.nextInt();
                if (minYear > 0) {
                    break;
                } else {
                    System.out.println("Enter a number greater than 0: ");
                }
            } else {
                scanner.nextLine();
                System.out.println("Enter a number: ");
            }
        }

        System.out.println("enter your maximum year: ");
        int maxYear;
        while (true) {
            if (scanner.hasNextInt()) {
                maxYear = scanner.nextInt();
                if (maxYear > 0) {
                    break;
                } else {
                    System.out.println("Enter a number greater than 0: ");
                }
            } else {
                scanner.nextLine();
                System.out.println("Enter a number: ");
            }
        }
        displayVehicles(dealership.getVehiclesByYear(minYear, maxYear));
        scanner.nextLine();
    }

    public void processGetByColorRequest(Scanner scanner) {
        System.out.println("enter your car color: ");
        String color = scanner.nextLine().trim();

        displayVehicles(dealership.getVehiclesByColor(color));
    }

    public void processGetByMileageRequest(Scanner scanner) {
        System.out.println("enter your minimum mileage: ");
        int minMileage;
        while (true) {
            if (scanner.hasNextInt()) {
                minMileage = scanner.nextInt();
                if (minMileage > 0) {
                    break;
                } else {
                    System.out.println("Enter a number greater than 0: ");
                }
            } else {
                scanner.nextLine();
                System.out.println("Enter a number: ");
            }
        }

        System.out.println("enter your maximum mileage: ");
        int maxMileage;
        while (true) {
            if (scanner.hasNextInt()) {
                maxMileage = scanner.nextInt();
                if (maxMileage >= minMileage) {
                    break;
                } else {
                    System.out.println("Enter a number greater than 0: ");
                }
            } else {
                scanner.nextLine();
                System.out.println("Enter a number: ");
            }
        }
        displayVehicles(dealership.getVehiclesByMileage(minMileage, maxMileage));
        scanner.nextLine();
    }

    public void processGetByVehicleTypeRequest(Scanner scanner) {
        System.out.println("enter the car type: ");
        String carType = scanner.nextLine().trim();

        displayVehicles(dealership.getVehiclesByType(carType));
    }

    public void processAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest(Scanner scanner) {

        System.out.println("enter your cars VIN: ");
        int vin;
        while (true) {
            if (scanner.hasNextInt()) {
                vin = scanner.nextInt();
                if (vin > 0) {
                    break;
                } else {
                    System.out.println("Enter a number greater than 0: ");
                }
            } else {
                System.out.println("Enter a number: ");
                scanner.nextLine();
            }
        }


        System.out.println("enter your cars year: ");
        int year;
        while (true) {
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year > 0) {
                    break;
                } else {
                    System.out.println("Enter a number greater than 0: ");
                }
            } else {
                System.out.println("Enter a number: ");
                scanner.nextLine();
            }
        }
        scanner.nextLine();


        System.out.println("enter your car make: ");
        String make = scanner.nextLine().trim();

        System.out.println("enter your car model: ");
        String model = scanner.nextLine().trim();

        System.out.println("enter the car type: ");
        String vehicleType = scanner.nextLine().trim();

        System.out.println("enter your car color: ");
        String color = scanner.nextLine().trim();

        System.out.println("enter your cars mileage: ");
        int odometer;
        while (true) {
            if (scanner.hasNextInt()) {
                odometer = scanner.nextInt();
                if (odometer >= 0) {
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Enter a number greater than 0: ");
                }
            } else {
                System.out.println("Enter a number: ");
                scanner.nextLine();
            }
        }

        System.out.println("enter your cars price: ");
        double price;
        while (true) {
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                if (price > 0) {
                    break;
                } else {
                    System.out.println("Enter a number greater than 0: ");
                }
            } else {
                System.out.println("Enter a number: ");
                scanner.nextLine();
            }
        }


        dealership.addVehicle(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
        new DealershipFileManager().saveDealership(dealership);
        scanner.nextLine();
    }


    public void processRemoveVehicleRequest(Scanner scanner) {
        //remove by exact vin
        System.out.println("enter your cars VIN: ");
        int vin = scanner.nextInt();
        scanner.nextLine();
        boolean on = true;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                dealership.removeVehicle(vehicle);
                on = false;
                System.out.println(vehicle.getVin() + " " + vehicle.getMake() + " " + vehicle.getModel() + " was removed");
                break;
            }
        }
        if (on) {
            System.out.println("no match found");
        }
        new DealershipFileManager().saveDealership(dealership);
    }
    public void processSalesContract(Scanner scanner) {
        System.out.println("enter date of sell");
        String date = scanner.nextLine();

        System.out.println("enter your name");
        String customerName = scanner.nextLine();

        System.out.println("enter your email");
        String customerEmail = scanner.nextLine();

        System.out.print("Enter the VIN of the vehicle: ");
        int vin = scanner.nextInt();

        Vehicle vehicleMatch = null;
        boolean vehicleFound = false;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                vehicleMatch = vehicle;
                vehicleFound = true;
                break;
            }
        }
        if (!vehicleFound) {
            System.out.println("Vehicle not found. Please try again.");
            return;
        }
        scanner.nextLine();

        System.out.println("double");
        double salesTax = scanner.nextDouble();

        System.out.println("recording fee");
        int recordingFee = scanner.nextInt();

        System.out.println("processing fee");
        int processingFee = scanner.nextInt();
        scanner.nextLine();

        System.out.println("do you want to finance the vehicle(Y/N)");
        boolean isFinanced = false;

        while (scanner.nextLine().isEmpty()) {
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                isFinanced = true;
                break;
            } else if (scanner.nextLine().equalsIgnoreCase("n")) {
                break;
            } else {
                System.out.println("enter yes or no");
            }
        }

        SalesContract sales = new SalesContract(date, customerName, customerEmail, vehicleMatch, salesTax, recordingFee, processingFee, isFinanced);

    }


    //helpers
    private void init() {
        DealershipFileManager manager = new DealershipFileManager();
        dealership = manager.getDealership();
    }

    private void displayVehicles(List<Vehicle> inventory) {
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.printf(" %s |\t%s\t|\t%s\t|\t%s\t|\t%s\t|\t%s\t| \t %s \t |\t%s\t|\n", "Vin   ", "Year", "Make", "Model", "Vehicle Type",
                "Color", "Odometer", "Price");
        System.out.println("---------------------------------------------------------------------------------------------------------");

        for (Vehicle vehicle : inventory) {
            System.out.printf("%s\t|\t%s\t|\t%s\t|\t%s\t|\t\t%s\t\t|\t%s\t|\t%s\t|\t%s|\n",
                    vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(),
                    vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
        }
        if (inventory.isEmpty()) {
            System.out.println("No match found");
        }
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }

    private void contractMenu(Scanner scanner){
        boolean end = false;
        while (!end) {
            System.out.println("---------- Contract Menu ----------");
            System.out.println("1. Add vehicle");
            System.out.println("2. Remove vehicle");
            System.out.println("3. sale a vehicles");
            System.out.println("4. lease a vehicles");
            System.out.println("5. quit");

            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    processAddVehicleRequest(scanner);;
                    break;
                case "2":
                    processRemoveVehicleRequest(scanner);
                    break;
                case "3":
                    processSalesContract(scanner);
                    break;
                case "4":
                    //processLeaseContract();
                    break;
                case "5":
                    end = true;
                    break;
            }
        }
    }

}
