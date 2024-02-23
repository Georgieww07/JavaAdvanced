import java.util.ArrayList;
import java.util.List;

public class Habitat {
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity){
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant){
        if (this.capacity > this.data.size()){
            this.data.add(elephant);
        }
    }

    public boolean remove(String name){
        for (Elephant e : this.data) {
            if (e.getName().equals(name)){
                this.data.remove(e);
                return true;
            }
        }
        return false;
    }

    public Elephant getElephant(String retiredFrom){
        for (Elephant e : this.data) {
            if (e.getRetiredFrom().equals(retiredFrom)){
                return e;
            }
        }
        return null;
    }

    public Elephant getOldestElephant(){
        return this.data.stream().max((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())).get();
    }

    public int getAllElephants(){
        return this.data.size();
    }

    public String getReport(){
        //Saved elephants in the park:
        //		 {name} came from: {retiredFrom}
        //          {name} came from: {retiredFrom}
        StringBuilder sb = new StringBuilder();
        sb.append("Saved elephants in the park:").append(System.lineSeparator());
        this.data.forEach(e -> sb.append(String.format("%s came from: %s", e.getName(), e.getRetiredFrom())).append(System.lineSeparator()));

        return sb.toString();
    }
}
