package RegularExam.ChasingSharks_03;

import java.util.ArrayList;
import java.util.List;

public class Basin {
    private List<Shark> sharks;
    private String name;
    private int capacity;


    public Basin(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.sharks = new ArrayList<>();
    }

    public void addShark(Shark shark){
        if (this.capacity > this.sharks.size()){
            this.sharks.add(shark);
        }else {
            System.out.println("This basin is at full capacity!");
        }
    }

    public boolean removeShark(String kind){
        for (Shark shark : this.sharks) {
            if (shark.getKind().equals(kind)){
                this.sharks.remove(shark);
                return true;
            }
        }
        return false;
    }

    public Shark getLargestShark(){
        return this.sharks.stream().max((s1, s2) -> Integer.compare(s1.getLength(), s2.getLength())).get();
    }

    public Shark getShark(String kind){
        for (Shark shark : this.sharks) {
            if (shark.getKind().equals(kind)){
                return shark;
            }
        }
        return null;
    }

    public int getCount(){
        return this.sharks.size();
    }

    public int getAverageLength(){
        int sumLength = 0;
        for (Shark shark : this.sharks) {
            int length = shark.getLength();
            sumLength += length;
        }
        sumLength /= this.sharks.size();

        return sumLength;
    }

    public String report(){
        //Sharks in {basin name}:
        //The {kind} is {length} centimeters long, eats {food} and inhabits {habitation}.

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Sharks in %s:", this.name)).append(System.lineSeparator());
        this.sharks.forEach(shark -> sb.append(shark).append(System.lineSeparator()));

        return sb.toString();
    }
}




















