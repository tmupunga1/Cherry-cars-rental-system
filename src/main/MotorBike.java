package main;

public class MotorBike extends Vehicle {
    private boolean hasSideCar;

    public MotorBike(String make, String model, int year, String regNumber, boolean hasSideCar) {
        super(make, model, year, regNumber);
        this.hasSideCar = hasSideCar;
    }

    public boolean isHasSideCar() {
        return hasSideCar;
    }

    @Override
    public double calculateCost(int days) {
        return days * 150;
    }

    @Override
    public String toString() {
        return super.toString() +",hasSideCar=" + hasSideCar ;
    }

    
}
