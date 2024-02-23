package DefiningClassesExercise.CarSalesMan_05;

public class Engine {
    private String engineModel;
    private int enginePower;
    private int engineDisplacement;
    private String engineEfficiency;


    public Engine(String engineModel, int enginePower, int engineDisplacement, String engineEfficiency) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.engineDisplacement = engineDisplacement;
        this.engineEfficiency = engineEfficiency;
    }

    public Engine(String engineModel, int enginePower, int engineDisplacement) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.engineDisplacement = engineDisplacement;
    }

    public Engine(String engineModel, int enginePower, String engineEfficiency) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.engineEfficiency = engineEfficiency;
    }


    public Engine(String engineModel, int enginePower) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public int getEngineDisplacement() {
        return engineDisplacement;
    }

    public String getEngineEfficiency() {
        return engineEfficiency;
    }
}
