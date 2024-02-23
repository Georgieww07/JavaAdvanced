package ExamPreparation.AnimalShelter_03;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private List<Animal> data;
    private int capacity;


    public Shelter(int capacity){
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal){
        if (this.capacity > this.data.size()){
            this.data.add(animal);
        }
    }

    public boolean remove(String name){
        for (Animal animal : this.data) {
            if (animal.getName().equals(name)){
                this.data.remove(animal);
                return true;
            }
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker){
        for (Animal animal : this.data) {
            if (animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)){
                return animal;
            }
        }
        return null;
    }

    public Animal getOldestAnimal(){
        return this.data.stream().max((a1, a2) -> Integer.compare(a1.getAge(), a2.getAge())).get();
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        //The shelter has the following animals:
        //{name} {caretaker}
        //{name} {caretaker}

        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:").append(System.lineSeparator());
        this.data.forEach(animal -> sb.append(animal.getName() + " " + animal.getCaretaker()).append(System.lineSeparator()));

        return sb.toString();
    }
}


























