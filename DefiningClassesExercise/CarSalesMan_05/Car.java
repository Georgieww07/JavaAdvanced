package DefiningClassesExercise.CarSalesMan_05;

import DefiningClassesExercise.CarSalesMan_05.Engine;

public class Car {
    private String model;
    public Engine engine;
    private int weight;
    private String colour;

    public Car(String model, Engine engine, int weight, String colour) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.colour = colour;
    }

    public Car(String model, Engine engine, int weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
    }

    public Car(String model, Engine engine, String colour) {
        this.model = model;
        this.engine = engine;
        this.colour = colour;
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getWeight() {
        return weight;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        //FordFocus:
        //V4-33:
        //Power: 140
        //Displacement: 28
        //Efficiency: B
        //Weight: 1300
        //Color: Silver
        return String.format("%s:%n%s:%nPower: %d", this.model, engine.getEngineModel(), engine.getEnginePower());
    }
}
