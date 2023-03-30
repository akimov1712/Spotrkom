package com.example.spotrkom.pojo;

public class ExerciseModel {

    private int imageExercise;
    private String nameExercise;

    public ExerciseModel(int imageExercise, String nameExercise) {
        this.imageExercise = imageExercise;
        this.nameExercise = nameExercise;
    }

    public int getImageExercise() {
        return imageExercise;
    }

    public void setImageExercise(int imageExercise) {
        this.imageExercise = imageExercise;
    }

    public String getNameExercise() {
        return nameExercise;
    }

    public void setNameExercise(String nameExercise) {
        this.nameExercise = nameExercise;
    }
}
