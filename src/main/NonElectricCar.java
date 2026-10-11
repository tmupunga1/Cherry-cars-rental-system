package main;

public class NonElectricCar extends Car{
    private String fuelType;

    public NonElectricCar(String make, String model, int year, String regNumber, int numDoors, String fuelType) {
        super(make, model, year, regNumber, numDoors);
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }

    @Override
    public double calculateCost(int days) {
        return days * 100;
    }

    @Override
    public String toString() {
        return super.toString() + ",fuelType=" + fuelType ;
    }

    
}
