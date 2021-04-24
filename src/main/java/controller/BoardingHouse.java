package controller;

import model.Student;

import java.util.ArrayList;

public class BoardingHouse {

    private final String CLASS_A = "A";
    private final String CLASS_B = "B";
    private final String FOOD_PREFERENCE_VEG = "V";
    private final String FOOD_PREFERENCE_NON_VEG = "NV";
    private int capacity;
    ArrayList<Integer> boardingHouseAWithVeg;
    ArrayList<Integer> boardingHouseAWithNonVeg;
    ArrayList<Integer> boardingHouseBWithVeg;
    ArrayList<Integer> boardingHouseBWithNonVeg;
    private String studeClassA;

    public BoardingHouse(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean createBoardingHouses() {
        boardingHouseAWithVeg = new ArrayList<>(capacity);
        boardingHouseAWithNonVeg = new ArrayList<>(capacity);
        boardingHouseBWithVeg = new ArrayList<>(capacity);
        boardingHouseBWithNonVeg = new ArrayList<>(capacity);
        return true;
    }

    public void assignedBoardingHouse(Student student) {

        if (CLASS_A.equals(student.getStudClass()) && FOOD_PREFERENCE_VEG.equals(student.getFoodPreference())){
            boardingHouseAWithVeg.add(student.getRegNumber());
        }

        if (CLASS_A.equals(student.getStudClass()) && FOOD_PREFERENCE_NON_VEG.equals(student.getFoodPreference())){
            boardingHouseAWithNonVeg.add(student.getRegNumber());
        }
    }
}
