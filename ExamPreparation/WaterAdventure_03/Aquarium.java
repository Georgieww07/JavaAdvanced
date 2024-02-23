package ExamPreparation.WaterAdventure_03;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size){
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int getSize(){
        return this.size;
    }

    public int getFishInPool(){
        return this.fishInPool.size();
    }

    public void add(Fish fish){

        boolean doesExist = false;

        if (this.capacity > this.fishInPool.size()){
            for (Fish f : this.fishInPool) {
                if (f.getName().equals(fish.getName())){
                    doesExist = true;
                }
            }
            if (!doesExist){
                this.fishInPool.add(fish);
            }
        }
    }

    public boolean remove(String name){
        for (Fish f : this.fishInPool) {
            if (f.getName().equals(name)){
                this.fishInPool.remove(f);
                return true;
            }
        }
        return false;
    }

    public Fish findFish(String name){
        for (Fish f : this.fishInPool) {
            if (f.getName().equals(name)){
                return f;
            }
        }
        return null;
    }

    public String report(){
        //Aquarium: {name} ^ Size: {size}
        //{Fish1}
        //{Fish2}
        StringBuilder sb = new StringBuilder();
        sb.append("Aquarium" + ": " + this.name + " ^ Size: " + this.size).append(System.lineSeparator());
        this.fishInPool.forEach(fish -> sb.append(fish).append(System.lineSeparator()));

        return sb.toString();
    }
}
