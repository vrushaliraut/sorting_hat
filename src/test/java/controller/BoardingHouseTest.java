package controller;

import model.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BoardingHouseTest {

    @Test
    void testShouldDefinedBoardingHouseWithSameCapacity() {
        BoardingHouse boardingHouse = new BoardingHouse(25);
        assertEquals(25, boardingHouse.getCapacity());
    }

    @Test
    void testShouldCreateBoardingHousesWithClassAndFoodPreference() {
        BoardingHouse boardingHouse = new BoardingHouse(25);
        assertTrue(boardingHouse.createBoardingHouses());
    }

    @Test
    void testShouldRegisteredStudentWithClassAVegPreference() {
        BoardingHouse boardingHouse = new BoardingHouse(25);
        boardingHouse.createBoardingHouses();
        Student student = new Student(0001, "A", "V");
        boardingHouse.assignedBoardingHouse(student);

        assertEquals(1, boardingHouse.boardingHouseAWithVeg.size());
    }
}