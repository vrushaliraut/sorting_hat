package model;

import java.util.Objects;

public class Student {

    private final int regNumber;
    private final String studClass;
    private final String foodPreference;

    public Student(int regNumber, String studClass, String foodPreference) {
        this.regNumber = regNumber;
        this.studClass = studClass;
        this.foodPreference = foodPreference;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public String getStudClass() {
        return studClass;
    }

    public String getFoodPreference() {
        return foodPreference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return regNumber == student.regNumber && Objects.equals(studClass, student.studClass) && Objects.equals(foodPreference, student.foodPreference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber, studClass, foodPreference);
    }
}
