package controller;

import model.Student;

import java.util.ArrayList;
import java.util.Arrays;

public class BoardingHouse {

    private final String CLASS_A = "A";
    private final String CLASS_B = "B";
    private final String FOOD_PREFERENCE_VEG = "V";
    private final int capacity;
    ArrayList<Integer> boardingHouseAWithVeg;
    ArrayList<Integer> boardingHouseAWithNonVeg;
    ArrayList<Integer> boardingHouseBWithVeg;
    ArrayList<Integer> boardingHouseBWithNonVeg;
    ArrayList<Integer> boardingHouseWithNA;

    public BoardingHouse(int eachBoardingHouseCapacity) {
        this.capacity = eachBoardingHouseCapacity;
        createBoardingHouses();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getCapacityOfEachBoardingHouse() {
        return capacity / 4;
    }

    public boolean isRegNumberUnique(int regNumber) {
        return !boardingHouseAWithVeg.contains(regNumber) && !boardingHouseAWithNonVeg.contains(regNumber) &&
                !boardingHouseBWithVeg.contains(regNumber) && !boardingHouseBWithNonVeg.contains(regNumber);
    }

    public void createBoardingHouses() {
        boardingHouseAWithVeg = new ArrayList<>(getCapacity());
        boardingHouseAWithNonVeg = new ArrayList<>(getCapacity());
        boardingHouseBWithVeg = new ArrayList<>(getCapacity());
        boardingHouseBWithNonVeg = new ArrayList<>(getCapacity());
        boardingHouseWithNA = new ArrayList<>();
    }

    public void assignedBoardingHouse(Student student) {
        if (isRegNumberUnique(student.getRegNumber())) {
            if (CLASS_A.equals(student.getStudClass())) {
                if (student.getFoodPreference().equals(FOOD_PREFERENCE_VEG)) {
                    addStudentToBoardingHouse(student, boardingHouseAWithVeg);
                } else {
                    addStudentToBoardingHouse(student, boardingHouseAWithNonVeg);
                }
            } else if (CLASS_B.equals(student.getStudClass())) {
                if (student.getFoodPreference().equals(FOOD_PREFERENCE_VEG)) {
                    addStudentToBoardingHouse(student, boardingHouseBWithVeg);
                } else {
                    addStudentToBoardingHouse(student, boardingHouseBWithNonVeg);
                }
            } else {
                System.out.println("Student class does not match");
            }
        } else {
            System.out.println("Student registration number is not unique :: " + student.getRegNumber());
        }
    }

    private void addStudentToBoardingHouse(Student student, ArrayList<Integer> list) {
        if (!addToNAArrayIfCapacityIsFull(list, student)) {
            list.add(student.getRegNumber());
        }
    }

    private boolean addToNAArrayIfCapacityIsFull(ArrayList<Integer> arrayList, Student student) {
        if (arrayList.size() >= getCapacity()) {
            boardingHouseWithNA.add(student.getRegNumber());
            return true;
        }
        return false;
    }

    private int totalHouseCapacity() {
        return capacity * 4;
    }

    private int totalFilledHouseCapacity() {
        return boardingHouseAWithVeg.size() + boardingHouseAWithNonVeg.size() +
                boardingHouseBWithVeg.size() + boardingHouseBWithNonVeg.size();
    }

    public String getRegisteredStudents() {
        String finalOutput = "Final Output ::\n AV : " +
                Arrays.toString(boardingHouseAWithVeg.toArray()) + "\n ANV : " +
                Arrays.toString(boardingHouseAWithNonVeg.toArray()) + "\n BV : " +
                Arrays.toString(boardingHouseBWithVeg.toArray()) + "\n BNV : " +
                Arrays.toString(boardingHouseBWithNonVeg.toArray()) + "\n NA : " +
                Arrays.toString(boardingHouseWithNA.toArray());
        return finalOutput;
    }
}
