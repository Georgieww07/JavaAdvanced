package ExamPreparation.Kindergarten_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child){
        if (this.capacity > this.registry.size()){
            this.registry.add(child);
            return true;
        }
        return false;
    }

    public boolean removeChild(String firstName){
        for (Child child : this.registry) {
            if (child.getFirstName().equals(firstName)){
                this.registry.remove(child);
                return true;
            }
        }
        return false;
    }

    public int getChildrenCount(){
        return this.registry.size();
    }

    public Child getChild(String firstName){
        for (Child child : this.registry) {
            if (child.getFirstName().equals(firstName)){
                return child;
            }
        }
        return null;
    }

    public String registryReport(){
        this.registry = this.registry.stream()
                .sorted(Comparator.comparingInt(Child::getAge)
                        .thenComparing(Comparator.comparing(child -> child.getFirstName()))
                        .thenComparing(Comparator.comparing(child -> child.getLastName())))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        sb.append("Registered children in " + this.name + ":").append(System.lineSeparator());

        for (Child child : this.registry) {
            sb.append("--").append(System.lineSeparator());
            sb.append(child).append(System.lineSeparator());

        }

        return sb.toString();
    }
}
