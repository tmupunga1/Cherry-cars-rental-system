package main;
public class Car extends Vehicle {
 private int numDoors;

 public Car(String make, String model, int year, String regNumber, int numDoors) {
    super(make, model, year, regNumber);
    this.numDoors = numDoors;
 }

 public int getNumDoors() {
    return numDoors;
 }

 
  @Override
    public double calculateCost(int days) {
        return 0; 
    }

 @Override
 public String toString() {
    return super.toString() + ",numDoors=" + numDoors ;
 }

   
}
