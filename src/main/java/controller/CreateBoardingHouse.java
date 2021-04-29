package controller;

import java.util.InputMismatchException;

public class CreateBoardingHouse implements SortingHatCommand {

    private static final String INVALID_INPUT = "Invalid Input: Use command init <4>";
    private static final String INVALID_BOARDING_HOUSE_CAPACITY = "Invalid Boarding house capacity";
    private static final String BLANK_STRING = " ";
    private static final int MAX_ARRAY_LENGTH = 2;

    private BoardingHouse boardingHouse;

    @Override
    public void execute(String command, BoardingHouse boardingHouse) throws UserDefinedException {
        String[] inputArray = command.split(BLANK_STRING);

        if (checkValidity(inputArray)) {
            throw new InputMismatchException(INVALID_INPUT);
        }

        int inputArrayNumber = Integer.parseInt(inputArray[1]);
        if (isValidCapacity(inputArrayNumber)) {
            int eachBoardingHouseCapacity = getCapacityOfEachBoardingHouse(inputArrayNumber);
            this.boardingHouse = new BoardingHouse(eachBoardingHouseCapacity);
        } else {
            throw new UserDefinedException(INVALID_BOARDING_HOUSE_CAPACITY);
        }
    }

    private boolean isValidCapacity(int capacity) {
        System.out.println("capacity: " + capacity);
        return capacity % 4 == 0;
    }

    private int getCapacityOfEachBoardingHouse(int inputArrayNumber) {
        return inputArrayNumber / 4;

    }

    @Override
    public boolean checkValidity(String[] inputArray) {
        if (inputArray.length != MAX_ARRAY_LENGTH) {
            return true;
        }
        try {
            Integer.parseInt(inputArray[1]);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    public BoardingHouse getBoardingHouseInstance() {
        return boardingHouse;
    }
}
