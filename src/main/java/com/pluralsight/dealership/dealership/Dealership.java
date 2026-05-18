package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private List<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * List<Vehicle> calls the Vehicle class to return an array out of each given data
     */

    public List<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice) {
        List<Vehicle> price = new ArrayList<>();
        for (Vehicle vehicle : getAllVehicles()) {
            if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice){
                price.add(vehicle);
            }
        }
        return price;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        List<Vehicle> makeModel = new ArrayList<>();
        for (Vehicle vehicle : getAllVehicles()) {
            if (vehicle.getMake().trim().equalsIgnoreCase(make) && vehicle.getModel().trim().equalsIgnoreCase(model) ){
                makeModel.add(vehicle);
            }
        }
        return makeModel;
    }

    public List<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
        List<Vehicle> year = new ArrayList<>();
        for (Vehicle vehicle : getAllVehicles()) {
            if (vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear){
                year.add(vehicle);
            }
        }
        return year;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> carColor = new ArrayList<>();
        for (Vehicle vehicle : getAllVehicles()) {
            if (vehicle.getColor().trim().equalsIgnoreCase(color)){
                carColor.add(vehicle);
            }
        }
        return carColor;
    }

    public List<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage) {
        List<Vehicle> Mileage = new ArrayList<>();
        for (Vehicle vehicle : getAllVehicles()) {
            if (vehicle.getOdometer() >= minMileage && vehicle.getOdometer() <= maxMileage){
                Mileage.add(vehicle);
            }
        }
        return Mileage;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> carType = new ArrayList<>();
        for (Vehicle vehicle : getAllVehicles()) {
            if (vehicle.getVehicleType().trim().equalsIgnoreCase(vehicleType)){
                carType.add(vehicle);
            }
        }
        return carType;
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    @Override
    public String toString() {
        return  name + address + phone + inventory;
    }
}
