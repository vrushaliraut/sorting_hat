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

    public boolean isRegNumberUnique(int regNumber) {
        if (boardingHouseAWithVeg.contains(regNumber) || boardingHouseAWithNonVeg.contains(regNumber) ||
                boardingHouseBWithVeg.contains(regNumber) || boardingHouseBWithNonVeg.contains(regNumber)) {
            return false;
        }
        return true;
    }

    public void assignedBoardingHouse(Student student) {

        if (isRegNumberUnique(student.getRegNumber())) {
            if (CLASS_A.equals(student.getStudClass()) && FOOD_PREFERENCE_VEG.equals(student.getFoodPreference())) {
                boardingHouseAWithVeg.add(student.getRegNumber());
            }

            if (CLASS_A.equals(student.getStudClass()) && FOOD_PREFERENCE_NON_VEG.equals(student.getFoodPreference())) {
                boardingHouseAWithNonVeg.add(student.getRegNumber());
            }

            if (CLASS_B.equals(student.getStudClass()) && FOOD_PREFERENCE_VEG.equals(student.getFoodPreference())) {
                boardingHouseBWithVeg.add(student.getRegNumber());
            }

            if (CLASS_B.equals(student.getStudClass()) && FOOD_PREFERENCE_NON_VEG.equals(student.getFoodPreference())) {
                boardingHouseBWithNonVeg.add(student.getRegNumber());
            }
        }

    }
}
