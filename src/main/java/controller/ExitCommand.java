package controller;

import java.util.InputMismatchException;

public class ExitCommand implements SortingHatCommand {

    private static final String BLANK_STRING = " ";
    private static final String INVALID_INPUT = "Invalid Input";

    @Override
    public void execute(String command, BoardingHouse boardingHouse) {
        String[] inputArray = command.split(BLANK_STRING);
        if (checkValidity(inputArray)) {
            throw new InputMismatchException(INVALID_INPUT);
        }
        System.out.println(boardingHouse.getRegisteredStudents());
        System.exit(0);
    }

    @Override
    public boolean checkValidity(String[] arg) {
        return arg.length != 1;
    }
}
