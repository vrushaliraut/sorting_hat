import controller.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String ENTER_INPUT_FROM_FILE = "Took Input From File ::\n";
    private static final String CREATE_BOARDING_HOUSE = "init";
    private static final String REGISTERED_STUDENT = "reg";
    private static final String EXIT_COMMAND = "fin";
    private static final String BLANK_STRING = " ";
    private static final String INVALID_INPUT = "Invalid Input";
    private static final String INVALID_BOARDING_HOUSE_CAPACITY = "Invalid Boarding house capacity";
    private static final String BOARDING_HOUSE_HAS_TO_BE_DEFINED_FIRST = "Boarding house has to be created first before any" +
            " operation \nRun init <Capacity>";
    private static final String ENTER_INPUT = "Enter Input";

    private static Map<String, SortingHatCommand> sortingHatCommandMap = new HashMap<>();

    public static void main(String[] args) {
        populateCommandMap();
        if (args.length == 1) {
            System.out.println(ENTER_INPUT_FROM_FILE);
            try {
                parseInputFromFile(readFromFile(args[0]));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println(ENTER_INPUT);
            Scanner scanner = readFromTerminal();
            parseInputFromFile(scanner);
        }
    }

    private static Scanner readFromTerminal() {
        return new Scanner(System.in);
    }

    private static void populateCommandMap() {
        sortingHatCommandMap.put(CREATE_BOARDING_HOUSE, new CreateBoardingHouse());
        sortingHatCommandMap.put(REGISTERED_STUDENT, new RegisteredStudent());
        sortingHatCommandMap.put(EXIT_COMMAND, new ExitCommand());

    }

    private static void parseInputFromFile(Scanner input) {
        String line;
        BoardingHouse boardingHouse = null;
        while (input.hasNextLine()) {
            line = input.nextLine();
            String[] inputArray = line.split(BLANK_STRING);
            try {
                if (inputArray[0].equals(EXIT_COMMAND)) {
                    new ExitCommand().execute(line, boardingHouse);
                } else if (boardingHouse == null && inputArray[0].equals(CREATE_BOARDING_HOUSE)) {
                    boardingHouse = createBoardingHouse(line, boardingHouse);
                    if (boardingHouse == null) {
                        System.out.println(INVALID_BOARDING_HOUSE_CAPACITY);
                        return;
                    }
                } else if (boardingHouse != null) {
                    boardingHouseOperations(line, boardingHouse, inputArray[0]);
                } else {
                    throw new NullPointerException(BOARDING_HOUSE_HAS_TO_BE_DEFINED_FIRST);
                }

            } catch (Exception | UserDefinedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void boardingHouseOperations(String line, BoardingHouse boardingHouse, String key) throws UserDefinedException, Exception {
        SortingHatCommand registeredStudent = sortingHatCommandMap.get(key);
        if (registeredStudent == null) {
            throw new InputMismatchException(INVALID_INPUT);
        }
        registeredStudent.execute(line, boardingHouse);
    }

    private static BoardingHouse createBoardingHouse(String line, BoardingHouse boardingHouse) {
        CreateBoardingHouse createBoardingHouse = new CreateBoardingHouse();
        try {
            createBoardingHouse.execute(line, boardingHouse);
        } catch (UserDefinedException exception) {
            if (INVALID_BOARDING_HOUSE_CAPACITY.equals(exception.getMessage())) {
                return null;
            }
        }
        boardingHouse = createBoardingHouse.getBoardingHouseInstance();
        return boardingHouse;
    }

    private static Scanner readFromFile(String path) throws FileNotFoundException {
        File file = new File(path);
        return new Scanner(file);
    }
}

