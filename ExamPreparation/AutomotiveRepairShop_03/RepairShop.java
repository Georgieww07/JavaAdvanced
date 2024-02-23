package ExamPreparation.AutomotiveRepairShop_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RepairShop {
    private List<Vehicle> vehicles;
    private int capacity;

    public RepairShop(int capacity){
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
        if (this.capacity > this.vehicles.size()){
            this.vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin){
        for (Vehicle vehicle : this.vehicles) {
            if (vehicle.getVIN().equals(vin)){
                this.vehicles.remove(vehicle);
                return true;
            }
        }
        return false;
    }

    public int getCount(){
        return this.vehicles.size();
    }

    public Vehicle getLowestMileage(){
        return this.vehicles.stream().min((v1, v2) -> Integer.compare(v1.getMileage(), v2.getMileage())).get();
    }

    public String report(){
        //Vehicles in the preparatory:
        //{Vehicle1}
        //{Vehicle2}
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicles in the preparatory:").append(System.lineSeparator());
        this.vehicles.forEach(vehicle -> sb.append(vehicle).append(System.lineSeparator()));

        return sb.toString();
    }
}
