package ExamPreparation.Workout_03;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise){
        if (this.exerciseCount > this.exercises.size()){
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle){
        for (Exercise exe : this.exercises) {
            if (exe.getName().equals(name) && exe.getMuscle().equals(muscle)){
                return this.exercises.remove(exe);
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle){
        for (Exercise exe : this.exercises) {
            if (exe.getName().equals(name) && exe.getMuscle().equals(muscle)){
                return exe;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise(){
        Exercise mostBurnedCalories = null;
        for (Exercise exercise : this.exercises) {
            if (mostBurnedCalories == null) {
                mostBurnedCalories = exercise;
            } else  {
                if (exercise.getBurnedCalories() > mostBurnedCalories.getBurnedCalories()) {
                    mostBurnedCalories = exercise;
                }
            }
        }
        return mostBurnedCalories;
    }

    public int getExerciseCount(){
        return this.exercises.size();
    }

    public String getStatistics(){
        //Workout type: {workout type}
        //Exercise: {Exercise1}
        //Exercise: {Exercise2}
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Workout type: %s", this.type)).append(System.lineSeparator());
        this.exercises.forEach(exercise -> sb.append(String.format("Exercise: %s", exercise.toString())).append(System.lineSeparator()));

        return sb.toString();
    }
}
