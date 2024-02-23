package ExamPreparation.WaterAdventure_03;

public class Fish {
    private String name;
    private String color;
    private int fins;

    public Fish(String name, String color, int fins) {
        this.name = name;
        this.color = color;
        this.fins = fins;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getFins() {
        return fins;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFins(int fins) {
        this.fins = fins;
    }

    @Override
    public String toString() {
        //Fish: {name}
        //Color: {color}
        //Number of fins: {fins}
        return String.format("Fish: %s%nColor: %s%nNumber of fins: %d", this.name, this.color, this.fins);
    }
}
