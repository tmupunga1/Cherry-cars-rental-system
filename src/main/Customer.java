package main;
import java.util.ArrayList;

public class Customer {
    private String licence;
    private ArrayList<Vehicle>currentRentals;
    private ArrayList<Vehicle> previousRentals;

    public Customer(String licence){
        this.licence = licence;
        currentRentals = new ArrayList<>();
        previousRentals = new ArrayList<>();
    }
   
    public String getLicence(){
        return licence;
    }
    public ArrayList<Vehicle> getCurrentRentals() {
        return currentRentals;
    }

    public ArrayList<Vehicle> getPreviousRentals() {
        return previousRentals;
    }
    public boolean rentVehicle(Vehicle veh){
        if(veh.isAvailable()){
            veh.rent(licence);
            currentRentals.add(veh);
            return true;
        }
        return false;
    }

    public boolean returnVehicle(Vehicle veh){
        if(currentRentals.contains(veh)){
            veh.returnVehicle();
            currentRentals.remove(veh);
            previousRentals.add(veh);
            return true;
        }
        return false;
    }

    

    @Override
    public String toString() {
        return "licence=" + licence + ", currentRentals=" + currentRentals + ", previousRentals="
                + previousRentals;
    }
    

}
