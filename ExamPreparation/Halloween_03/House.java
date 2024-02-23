package ExamPreparation.Halloween_03;

import java.util.ArrayList;
import java.util.List;

public class House {
    private int capacity;
    private List<Kid> data;


    public House(int capacity){
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addKid(Kid kid){
        if (this.capacity > this.data.size()){
            this.data.add(kid);
        }
    }

    public boolean removeKid(String name){
        for (Kid kid : this.data) {
            if (kid.getName().equals(name)){
                this.data.remove(kid);
                return true;
            }
        }
        return false;
    }

    public Kid getKid(String street){
        for (Kid kid : this.data) {
            if (kid.getStreet().equals(street)){
                return kid;
            }
        }
        return null;
    }

    public int getAllKids(){
        return this.data.size();
    }

    public String getStatistics(){
        //Children who visited a house for candy:
        //{name} from {street} street
        //{name} from {street} street

        StringBuilder sb = new StringBuilder();
        sb.append("Children who visited a house for candy:").append(System.lineSeparator());
        this.data.forEach(kid -> sb.append(String.format("%s from %s street", kid.getName(), kid.getStreet())).append(System.lineSeparator()));

        return sb.toString();

    }

}
