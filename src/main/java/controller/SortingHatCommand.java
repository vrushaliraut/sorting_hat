package controller;

public interface SortingHatCommand {

    void execute(String command, BoardingHouse boardingHouse) throws Exception, UserDefinedException;

    boolean checkValidity(String[] array);
}
