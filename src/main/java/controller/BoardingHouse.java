package controller;

import model.Student;

import java.util.ArrayList;
import java.util.Arrays;

public class BoardingHouse {

    private final String CLASS_A = "A";
    private final String CLASS_B = "B";
    private final String FOOD_PREFERENCE_VEG = "V";
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

    public void createBoardingHouses() {
        boardingHouseAWithVeg = new ArrayList<>(capacity);
        boardingHouseAWithNonVeg = new ArrayList<>(capacity);
        boardingHouseBWithVeg = new ArrayList<>(capacity);
        boardingHouseBWithNonVeg = new ArrayList<>(capacity);
    }

    public boolean isRegNumberUnique(int regNumber) {
        return !boardingHouseAWithVeg.contains(regNumber) && !boardingHouseAWithNonVeg.contains(regNumber) &&
                !boardingHouseBWithVeg.contains(regNumber) && !boardingHouseBWithNonVeg.contains(regNumber);
    }

    public void assignedBoardingHouse(ArrayList<Student> studentList) {
        if (studentList.size() <= totalHouseCapacity()) {
            for (Student student : studentList) {
                if (isRegNumberUnique(student.getRegNumber())) {
                    if (CLASS_A.equals(student.getStudClass())) {
                        if (student.getFoodPreference().equals(FOOD_PREFERENCE_VEG)) {
                            boardingHouseAWithVeg.add(student.getRegNumber());
                        } else {
                            boardingHouseAWithNonVeg.add(student.getRegNumber());
                        }
                    } else if (CLASS_B.equals(student.getStudClass())) {
                        if (student.getFoodPreference().equals(FOOD_PREFERENCE_VEG)) {
                            boardingHouseBWithVeg.add(student.getRegNumber());
                        } else {
                            boardingHouseBWithNonVeg.add(student.getRegNumber());
                        }
                    } else {
                        System.out.println("Student class does not match");
                    }
                } else {
                    System.out.println("Student registration number is not unique");
                }
            }
        } else {
            System.out.println("Boarding house capacity will not be able to fulfill requests");
        }
    }

    private int totalHouseCapacity() {
        return capacity * 4;
    }

    public String registeredStudents() {
        String finalOutput = "Final Output ::\n AV : " + Arrays.toString(boardingHouseAWithVeg.toArray()) + "\n ANV : " +
                Arrays.toString(boardingHouseAWithNonVeg.toArray()) + "\n BV : " +
                Arrays.toString(boardingHouseBWithVeg.toArray()) + "\n BNV :" +
                Arrays.toString(boardingHouseBWithNonVeg.toArray());
        return finalOutput;
    }
}
