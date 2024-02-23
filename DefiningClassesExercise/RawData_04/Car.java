package DefiningClassesExercise.RawData_04;

public class Car {
    private String model;
    public Engine engine;
    public Cargo cargo;
    public Tire tire;



    public Car(String model, Engine engine, Cargo cargo, Tire tire){
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire = tire;
    }


    public Cargo getCargo() {
        return cargo;
    }

    public Tire getTire() {
        return tire;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }
}
