package main;
public abstract class Vehicle {
    private String make;
    private String model;
    private int year;
    private String regNumber;
    private String rentedBy = "";

    public Vehicle(String make, String model, int year, String regNumber) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.regNumber = regNumber;
        this.rentedBy = "";
    }

    public boolean isAvailable(){
        return rentedBy.equals("");
    }
    
    public void rent(String licence){
        this.rentedBy = licence;
    }

    public void returnVehicle(){
        this.rentedBy = "";
    }
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getRentedBy() {
        return rentedBy;
    }

    public abstract double calculateCost(int days);
    

    @Override
    public String toString() {
        return "make=" + make + ", model=" + model + ", year=" + year + ", regNumber=" + regNumber
                + ", rentedBy=" + rentedBy;
    }

   
    
}