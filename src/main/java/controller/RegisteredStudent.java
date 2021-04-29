package controller;

import model.Student;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class RegisteredStudent implements SortingHatCommand {

    private static final String BLANK_STRING = " ";
    private static final String INVALID_INPUT = "Invalid Input: Use command reg 1 B V";

    @Override
    public void execute(String command, BoardingHouse boardingHouse) {
        String[] arr = command.split(BLANK_STRING);

        if (!checkValidity(arr)) {
            throw new InputMismatchException(INVALID_INPUT);
        }
        ArrayList<Student> students = getStudentArrayList(arr);
        boardingHouse.assignedBoardingHouse(students);
    }

    private ArrayList<Student> getStudentArrayList(String[] arr) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(Integer.parseInt(arr[1]), arr[2], arr[3]));
        return students;
    }

    @Override
    public boolean checkValidity(String[] array) {
        return array.length == 4;
    }
}
