package main;
import java.util.ArrayList;

public class CherryCars {
    private ArrayList<Vehicle> vehicles;

     public CherryCars(){
        vehicles = new ArrayList<>();
     }

   public void addVehicle(Vehicle veh){
    vehicles.add(veh);
   }

   public Vehicle findVehicle(String reg){
    for (Vehicle veh : vehicles){
        if (veh.getRegNumber().equalsIgnoreCase(reg)){
            return veh;
        }
    }
    return null;
   }

   public ArrayList<Vehicle> getVehicles(){
    return vehicles;
   }
   
   public ArrayList<Vehicle> getAvailableVehicles(){
    ArrayList<Vehicle> available = new ArrayList<>();
    
    for(Vehicle veh: vehicles){
        if(veh.isAvailable()){
            available.add(veh);
        }
    }
    return available;
   }
   public ArrayList<Vehicle> getAvailableByMake(String make) {

    ArrayList<Vehicle> result = new ArrayList<>();

    for (Vehicle v : vehicles) {

        if (
            v.isAvailable() &&
            v.getMake().equalsIgnoreCase(make)
        ) {

            result.add(v);
        }
    }

    return result;
}
}

