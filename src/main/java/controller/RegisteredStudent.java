package controller;

import model.Student;

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
        boardingHouse.assignedBoardingHouse(getStudent(arr));
    }

    private Student getStudent(String[] arr) {
        return new Student(Integer.parseInt(arr[1]), arr[2], arr[3]);
    }

    @Override
    public boolean checkValidity(String[] array) {
        return array.length == 4;
    }
}
