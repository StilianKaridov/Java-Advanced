package advanced.exam.workout;

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

    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < this.exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        return this.exercises
                .removeIf(e -> e.getName().equals(name) && e.getMuscle().equals(muscle));
    }

    public Exercise getExercise(String name, String muscle) {
        return this.exercises.stream()
                .filter(e -> e.getName().equals(name) && e.getMuscle().equals(muscle))
                .findFirst().orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise() {
        Exercise toReturn = exercises.get(0);

        for (Exercise exercise : exercises) {
            if (exercise.getBurnedCalories() > toReturn.getBurnedCalories()) {
                toReturn = exercise;
            }
        }

        return toReturn;
    }

    public int getExerciseCount() {
        return this.exercises.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Workout type: %s%n", this.type));

        for (Exercise exercise : this.exercises) {
            sb.append(String.format("%s%n", exercise.toString()));
        }

        return sb.toString().trim();
    }
}
