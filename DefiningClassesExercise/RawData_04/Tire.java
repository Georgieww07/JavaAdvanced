package DefiningClassesExercise.RawData_04;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tire {
    private Map<Double, Integer> tireInfo;

    public Tire(Map<Double, Integer> tireInfo) {
        this.tireInfo = tireInfo;
    }

    public boolean checkTires(){
        //return tireInfo.entrySet().stream().filter(e -> e.getKey() < 1).collect(Collectors.toList());
        for (Map.Entry<Double, Integer> entry : tireInfo.entrySet()) {
            if (entry.getKey() < 1){
                return true;
            }
        }
        return false;
    }
}
