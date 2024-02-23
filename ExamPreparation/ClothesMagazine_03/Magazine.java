package ExamPreparation.ClothesMagazine_03;

import java.util.ArrayList;
import java.util.List;

public class Magazine {
    private String type;
    private int capacity;
    private List<Cloth> data;


    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addCloth(Cloth cloth){
        if (this.capacity > this.data.size()){
            this.data.add(cloth);
        }
    }

    public boolean removeCloth(String color){
        for (Cloth cloth : data) {
            if (cloth.getColor().equals(color)){
                data.remove(cloth);
                return true;
            }
        }
        return false;
    }

    public Cloth getSmallestCloth(){
        Cloth smallestCloth = new Cloth(null, Integer.MAX_VALUE, null);
        for (Cloth cloth : data) {
            if (cloth.getSize() < smallestCloth.getSize()){
                smallestCloth = cloth;
            }
        }
        return smallestCloth;
    }

    public Cloth getCloth(String color){
        for (Cloth cloth : data) {
            if (cloth.getColor().equals(color)){
                return cloth;
            }

        }
        return null;
    }

    public int getCount(){
        return data.size();
    }

    public String report(){
        //"{type} magazine contains:
        //{Cloth1}
        //{Cloth2}

        StringBuilder sb = new StringBuilder();
        sb.append(this.type + " magazine contains:" + System.lineSeparator());
        for (Cloth cloth : data) {
            sb.append(cloth + System.lineSeparator());

        }


        return sb.toString().trim();
    }
}
