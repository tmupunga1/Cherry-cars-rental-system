package main;
public class ElectricCar extends Car {
    private int milesPerCharge;

    public ElectricCar(String make, String model, int year, String regNumber, int numDoors, int milesPerCharge) {
        super(make, model, year, regNumber, numDoors);
        this.milesPerCharge = milesPerCharge;
    }

    public int getMilesPerCharge() {
        return milesPerCharge;
    }
 @Override
    public double calculateCost(int days) {
        return days * 120;
    }

    @Override
    public String toString() {
        return super.toString() + ",milesPerCharge=" + milesPerCharge ;
    }

    
}